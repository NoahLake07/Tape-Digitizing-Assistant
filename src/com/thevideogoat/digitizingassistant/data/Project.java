package com.thevideogoat.digitizingassistant.data;

import com.thevideogoat.digitizingassistant.ui.DigitizingAssistant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;

public class Project implements Serializable {

    String name;
    ArrayList<Conversion> conversions;

    public Project(String name){
        conversions = new ArrayList<>();
        this.name = name;
    }

    public Project (Path source){
        // deserialize the project from the source
        try {
            FileInputStream fileIn = new FileInputStream(source.toString());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileIn);
            Project project = (Project) objectInputStream.readObject();
            this.name = project.name;
            this.conversions = project.conversions;
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // update serial ids if from an older version
        for (Conversion conversion : conversions) {
            if (conversion.version == null || conversion.version != DigitizingAssistant.VERSION) {
                conversion.version = DigitizingAssistant.VERSION;
            }
        }
    }

    public Project(File jsonFile) {
        try {
            // Read the JSON file
            String jsonContent = new String(Files.readAllBytes(jsonFile.toPath()));
            JsonObject jsonObject = JsonParser.parseString(jsonContent).getAsJsonObject();
            
            // Parse project name
            this.name = jsonObject.get("name").getAsString();
            this.conversions = new ArrayList<>();
            
            // Parse conversions
            JsonArray conversionsArray = jsonObject.getAsJsonArray("conversions");
            for (JsonElement element : conversionsArray) {
                JsonObject conversionJson = element.getAsJsonObject();
                Conversion conversion = new Conversion(conversionJson.get("name").getAsString());
                conversion.type = Type.fromDisplayName(conversionJson.get("type").getAsString());
                
                // Handle status by display name
                String statusStr = conversionJson.get("status").getAsString();
                for (ConversionStatus status : ConversionStatus.values()) {
                    if (status.toString().equals(statusStr)) {
                        conversion.status = status;
                        break;
                    }
                }
                
                conversion.note = conversionJson.get("note").getAsString();
                
                // Handle new fields for version 1.5
                if (conversionJson.has("technicianNotes")) {
                    conversion.technicianNotes = conversionJson.get("technicianNotes").getAsString();
                } else {
                    conversion.technicianNotes = "";
                }
                
                if (conversionJson.has("isDataOnly")) {
                    conversion.isDataOnly = conversionJson.get("isDataOnly").getAsBoolean();
                } else {
                    conversion.isDataOnly = false;
                }
                
                conversion.duration = Duration.parse(conversionJson.get("duration").getAsString());
                
                // Handle linked files
                if (conversionJson.has("linkedFiles")) {
                    JsonArray linkedFilesArray = conversionJson.getAsJsonArray("linkedFiles");
                    conversion.linkedFiles = new ArrayList<>();
                    for (JsonElement fileElement : linkedFilesArray) {
                        String filePath = fileElement.getAsString();
                        FileReference fileRef = new FileReference(filePath);
                        if (fileRef.exists()) {
                            conversion.linkedFiles.add(fileRef);
                        }
                    }
                }
                
                this.conversions.add(conversion);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file: " + e.getMessage(), e);
        }
    }

    public void addConversion(Conversion conversion){
        conversions.add(conversion);
    }

    public void saveToFile(Path destination) {
        File projectFile = Paths.get(destination.toString(), name + ".json").toFile();

        try {
            // Create JSON object
            JsonObject projectJson = new JsonObject();
            projectJson.addProperty("name", name);
            projectJson.addProperty("version", DigitizingAssistant.VERSION);
            
            // Add conversions
            JsonArray conversionsArray = new JsonArray();
            for (Conversion conversion : conversions) {
                JsonObject conversionJson = new JsonObject();
                conversionJson.addProperty("name", conversion.name);
                conversionJson.addProperty("type", conversion.type.toString());
                conversionJson.addProperty("status", conversion.status.toString());
                conversionJson.addProperty("note", conversion.note);
                conversionJson.addProperty("technicianNotes", conversion.technicianNotes);
                conversionJson.addProperty("isDataOnly", conversion.isDataOnly);
                conversionJson.addProperty("duration", conversion.duration.toString());
                
                // Add linked files
                JsonArray linkedFilesArray = new JsonArray();
                if (conversion.linkedFiles != null) {
                    for (FileReference fileRef : conversion.linkedFiles) {
                        linkedFilesArray.add(fileRef.getPath());
                    }
                }
                conversionJson.add("linkedFiles", linkedFilesArray);
                
                conversionsArray.add(conversionJson);
            }
            projectJson.add("conversions", conversionsArray);
            
            // Write to file
            try (FileWriter writer = new FileWriter(projectFile)) {
                new GsonBuilder().setPrettyPrinting().create().toJson(projectJson, writer);
            }
        } catch (IOException e) {
            throw new Error("Failed to save project to file.", e);
        }
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Conversion> getConversions(){
        return this.conversions;
    }
    
    public void setConversions(ArrayList<Conversion> conversions){
        this.conversions = conversions;
    }

}
