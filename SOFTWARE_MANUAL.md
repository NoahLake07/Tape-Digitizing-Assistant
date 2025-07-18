# TVG Digitizing Assistant - Software Manual

**Version:** 1.4  
**Last Updated:** December 2024  
**Author:** TVG Development Team

---

## Table of Contents

1. [Introduction](#introduction)
2. [System Requirements](#system-requirements)
3. [Installation](#installation)
4. [Getting Started](#getting-started)
5. [User Interface Overview](#user-interface-overview)
6. [Project Management](#project-management)
7. [Conversion Management](#conversion-management)
8. [File Management](#file-management)
9. [Advanced Features](#advanced-features)
10. [Keyboard Shortcuts](#keyboard-shortcuts)
11. [Troubleshooting](#troubleshooting)
12. [Technical Specifications](#technical-specifications)

---

## Introduction

The TVG Digitizing Assistant is a Java-based desktop application designed to streamline and organize the process of digitizing various types of media tapes and discs. This professional tool helps media digitization professionals, archivists, and content creators manage their digitization projects efficiently.

### Key Features

- **Project Management**: Create and manage multiple digitization projects
- **Conversion Tracking**: Track individual media conversions with detailed metadata
- **File Linking**: Associate digitized files with their source media
- **Status Management**: Monitor progress through various conversion stages
- **Data Persistence**: Save and resume work with automatic project saving
- **Modern Interface**: Clean, intuitive user interface with dark theme
- **Cross-Platform**: Runs on Windows, macOS, and Linux

### Supported Media Types

- VHS
- VHS-C
- 8mm
- Betamax
- MiniDV
- CD/DVD
- Type II

---

## System Requirements

### Minimum Requirements

- **Operating System**: Windows 10, macOS 10.14+, or Linux (Ubuntu 18.04+)
- **Java Runtime**: Java 8 or higher
- **Memory**: 2 GB RAM
- **Storage**: 100 MB available space
- **Display**: 1024x768 resolution minimum

### Recommended Requirements

- **Operating System**: Windows 11, macOS 12+, or Linux (Ubuntu 20.04+)
- **Java Runtime**: Java 11 or higher
- **Memory**: 4 GB RAM or higher
- **Storage**: 500 MB available space
- **Display**: 1920x1080 resolution or higher

---

## Installation

### Windows Installation

1. **Download the Application**
   - Download the latest JAR file from the releases page
   - Extract the ZIP file to your desired location

2. **Install Java (if not already installed)**
   - Download and install Java 11 or higher from Oracle or OpenJDK
   - Verify installation by opening Command Prompt and typing: `java -version`

3. **Run the Application**
   - Double-click the JAR file, or
   - Open Command Prompt in the application directory and run: `java -jar DigitizingAssistant.jar`

### macOS Installation

1. **Download the Application**
   - Download the latest JAR file from the releases page
   - Extract the ZIP file to your Applications folder

2. **Install Java (if not already installed)**
   - Download and install Java 11 or higher
   - Verify installation by opening Terminal and typing: `java -version`

3. **Run the Application**
   - Double-click the JAR file, or
   - Open Terminal and run: `java -jar DigitizingAssistant.jar`

### Linux Installation

1. **Download the Application**
   - Download the latest JAR file from the releases page
   - Extract the ZIP file to your desired location

2. **Install Java (if not already installed)**
   ```bash
   sudo apt update
   sudo apt install openjdk-11-jre
   ```

3. **Run the Application**
   ```bash
   java -jar DigitizingAssistant.jar
   ```

---

## Getting Started

### First Launch

When you first launch the TVG Digitizing Assistant, you'll see the project selection screen:

1. **Create a New Project**
   - Click the "New Project" button
   - Enter a project name (e.g., "Client Name - December 2024")
   - Click "OK" to create the project

2. **Open Existing Project**
   - Select a project from the list
   - Click "Open Project" to load it

### Project Structure

Each project contains:
- **Project Name**: Identifies the client or collection
- **Conversions**: Individual media items being digitized
- **Metadata**: Detailed information about each conversion
- **Linked Files**: Associated digitized media files

---

## User Interface Overview

### Main Window Layout

The main application window is divided into several key areas:

#### 1. Title Bar
- **Project Name**: Displays current project name and version
- **Menu Button (≡)**: Access to additional tools and options
- **Window Controls**: Minimize, maximize, close

#### 2. Sidebar (Left Panel)
- **Search Bar**: Filter conversions by name
- **Conversion List**: All conversions in the current project
- **New Conversion Button**: Add new media items
- **Status Indicators**: Color-coded conversion status

#### 3. Main Content Area (Right Panel)
- **Conversion Details**: Detailed information about selected conversion
- **File Management**: Linked files and media information
- **Metadata Fields**: Type, notes, dates, times, duration

#### 4. Status Bar (Bottom)
- **Save Status**: Indicates when changes are saved
- **Project Statistics**: Total conversions and completion status

### Color-Coded Status System

- **Gray**: Not Started
- **Red**: Damaged
- **Orange**: In Progress
- **Blue**: Basic Editing
- **Green**: Completed

---

## Project Management

### Creating a New Project

1. **From Project Selection Screen**
   - Click "New Project"
   - Enter project name
   - Click "OK"

2. **From Menu**
   - Click menu button (≡)
   - Select "New Project"
   - Enter project name

### Opening Projects

1. **From Project Selection Screen**
   - Select project from list
   - Click "Open Project"

2. **From File System**
   - Use menu → "Import Project"
   - Navigate to project file (.json)
   - Select and open

### Saving Projects

- **Automatic Saving**: Projects save automatically when changes are made
- **Manual Save**: Use Ctrl+S or menu options
- **Save Status**: Status bar shows "Saved" when complete

### Project File Location

Projects are stored in:
- **Windows**: `%USERPROFILE%\Documents\.digitizing-assistant\projects\`
- **macOS**: `~/Documents/.digitizing-assistant/projects/`
- **Linux**: `~/Documents/.digitizing-assistant/projects/`

---

## Conversion Management

### Creating a New Conversion

1. **From Sidebar**
   - Click "New Conversion" button
   - Enter conversion name (e.g., "Tape 001 - Family Vacation")
   - Press Enter or click outside to confirm

2. **From Menu**
   - Use Ctrl+N keyboard shortcut
   - Enter conversion name

### Conversion Details

Each conversion contains the following information:

#### Basic Information
- **Name**: Descriptive name for the media item
- **Type**: Media format (VHS, VHS-C, 8mm, etc.)
- **Status**: Current progress status
- **Notes**: Additional information or instructions

#### Temporal Information
- **Date of Conversion**: When digitization occurred
- **Time of Conversion**: Time of day for digitization
- **Duration**: Length of the media content

#### File Management
- **Linked Files**: Associated digitized files
- **File Operations**: Open, relink, remove files

### Editing Conversion Details

1. **Select Conversion**: Click on conversion in sidebar
2. **Modify Fields**: Edit any field in the main panel
3. **Auto-Save**: Changes save automatically
4. **Status Updates**: Use status dropdown to update progress

### Deleting Conversions

1. **Right-click** on conversion in sidebar
2. **Select "Delete"** from context menu
3. **Confirm deletion** in dialog box

---

## File Management

### Linking Files to Conversions

1. **Add Files Button**
   - Click "Add Files" in conversion details
   - Select files from file dialog
   - Files are linked to the conversion

2. **Drag and Drop**
   - Drag files from file explorer
   - Drop onto the conversion in sidebar
   - Files are automatically linked

### File Operations

#### Opening Files
- **Double-click** file in linked files list
- **Right-click** → "Open File"
- Files open with default system application

#### Relinking Files
- **Right-click** file → "Relink File"
- Navigate to new file location
- Select replacement file

#### Removing Files
- **Right-click** file → "Remove File"
- File is unlinked (not deleted from disk)

### File Validation

The application automatically:
- **Checks file existence** when loading projects
- **Warns about missing files** with option to relink
- **Validates file paths** for cross-platform compatibility

---

## Advanced Features

### Search and Filter

1. **Search Bar**
   - Type in sidebar search field
   - Real-time filtering of conversions
   - Searches conversion names

2. **Status Filtering**
   - Use status indicators to filter
   - Click status colors to show only matching conversions

### Keyboard Navigation

- **Arrow Keys**: Navigate between conversions
- **Enter**: Edit conversion name
- **Escape**: Cancel editing

### Project Export

1. **Export as JSON**
   - Menu → "Export Project as JSON"
   - Save project data in JSON format
   - Useful for backup or data migration

### Media Statistics

1. **Access Statistics**
   - Menu → "Media Statistics"
   - View project overview including:
     - Total conversions by status
     - File size totals
     - Duration totals
     - Media type distribution

### File Operations

#### Relink Trimmed Files
- **Menu → "Relink to Trimmed Files"**
- Automatically finds trimmed versions of linked files
- Useful for post-processing workflows

#### Find and Relink Trimmed Media
- **Menu → "Find and Relink Trimmed Media"**
- Searches subdirectories for trimmed versions
- Batch relinking of multiple files

#### Rename Project Files
- **Menu → "Rename Project Files"**
- Batch rename linked files
- Maintains file associations

### Tools Integration

The application includes quick access to common digitization tools:

- **HandBrake**: Video transcoding
- **MakeMKV**: DVD/Blu-ray ripping
- **LosslessCut**: Video editing

Access via menu → "Tools" submenu.

---

## Keyboard Shortcuts

| Shortcut | Action |
|----------|--------|
| `Ctrl+N` | New Conversion |
| `Ctrl+S` | Save Project |
| `Ctrl+O` | Open Project |
| `Ctrl+F` | Focus Search Field |
| `Delete` | Delete Selected Conversion |
| `Enter` | Edit Conversion Name |
| `Escape` | Cancel Editing |
| `↑/↓` | Navigate Conversions |
| `F5` | Refresh Conversion List |

### Context-Specific Shortcuts

#### In Conversion Details
- **Tab**: Navigate between fields
- **Enter**: Save changes
- **Escape**: Cancel changes

#### In File Lists
- **Double-click**: Open file
- **Delete**: Remove file link
- **Ctrl+A**: Select all files

---

## Troubleshooting

### Common Issues

#### Application Won't Start

**Problem**: Application fails to launch
**Solutions**:
1. Verify Java installation: `java -version`
2. Update to Java 11 or higher
3. Check file permissions
4. Run from command line for error messages

#### Projects Not Loading

**Problem**: Can't open existing projects
**Solutions**:
1. Check project file location
2. Verify file permissions
3. Check for corrupted project files
4. Try importing project manually

#### Files Not Linking

**Problem**: Can't link files to conversions
**Solutions**:
1. Check file permissions
2. Verify file exists
3. Try relinking manually
4. Check file path length

#### Performance Issues

**Problem**: Application runs slowly
**Solutions**:
1. Close other applications
2. Increase available RAM
3. Check disk space
4. Restart application

### Error Messages

#### "File Not Found"
- File has been moved or deleted
- Use relink option to find new location
- Check file permissions

#### "Project Save Failed"
- Check disk space
- Verify write permissions
- Try saving to different location

#### "Invalid Project Format"
- Project file may be corrupted
- Try opening backup file
- Contact support if no backup available

### Data Recovery

#### Automatic Backups
- Projects save automatically
- Check project directory for backup files
- Look for `.json` files with timestamps

#### Manual Recovery
1. Navigate to project directory
2. Look for `.json` files
3. Try opening with text editor
4. Import as new project if needed

---

## Technical Specifications

### File Formats

#### Project Files
- **Format**: JSON
- **Extension**: `.json`
- **Encoding**: UTF-8
- **Structure**: Hierarchical with conversions array

#### Data Structure
```json
{
  "name": "Project Name",
  "version": "1.4",
  "conversions": [
    {
      "name": "Conversion Name",
      "type": "VHS",
      "status": "COMPLETED",
      "note": "Notes",
      "duration": "PT1H30M",
      "linkedFiles": ["/path/to/file.mp4"]
    }
  ]
}
```

### System Integration

#### File Associations
- **Project Files**: `.json` extension
- **Media Files**: System default applications
- **Export Files**: Text editors or JSON viewers

#### Operating System Compatibility
- **Windows**: Windows 10/11
- **macOS**: 10.14+ (Mojave and later)
- **Linux**: Ubuntu 18.04+, other distributions with Java support

### Performance Characteristics

#### Memory Usage
- **Minimum**: 50 MB
- **Typical**: 100-200 MB
- **Large Projects**: 500 MB+

#### Storage Requirements
- **Application**: 100 MB
- **Project Files**: 1-10 KB per conversion
- **Temporary Files**: Minimal

#### Network Requirements
- **None**: Application runs locally
- **Optional**: File sharing for collaborative work

### Security Considerations

#### Data Privacy
- All data stored locally
- No network transmission
- No cloud services used

#### File Access
- Read/write access to project directory
- Read access to linked media files
- No system-level permissions required

---

## Support and Contact

### Getting Help

1. **Check this manual** for common solutions
2. **Review error messages** for specific issues
3. **Check system requirements** for compatibility
4. **Verify file permissions** and disk space

### Reporting Issues

When reporting issues, please include:
- Application version
- Operating system and version
- Java version
- Steps to reproduce the issue
- Error messages (if any)
- Project file sample (if relevant)

### Feature Requests

For feature requests or suggestions:
- Describe the desired functionality
- Explain the use case
- Provide examples if possible

---

## Version History

### Version 1.4 (Current)
- Enhanced file management
- Improved search functionality
- Better error handling
- Performance optimizations

### Version 1.1
- JSON project format
- Enhanced UI
- File linking improvements

### Version 1.0
- Initial release
- Basic project management
- Conversion tracking

---

## License and Legal

This software is provided as-is for professional use. Users are responsible for:
- Ensuring proper licensing for digitized content
- Complying with copyright laws
- Maintaining data backups
- Using appropriate digitization equipment

---

*This manual covers TVG Digitizing Assistant version 1.4. For the latest information, check the application's help menu or contact support.*
