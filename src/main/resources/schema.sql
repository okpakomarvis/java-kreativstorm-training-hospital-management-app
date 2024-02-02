CREATE TABLE IF NOT EXISTS Department
(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    DepartmentName VARCHAR(50) NOT NULL
    );

-- ---------------------------------------------
-- USERS
-- ---------------------------------------------
CREATE TABLE IF NOT EXISTS Users
(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(50) NOT NULL,
    Password VARCHAR(50) NOT NULL,
    Role VARCHAR(50) NOT NULL CHECK (Role IN ('DOCTOR', 'NURSE', 'ADMIN', 'PATIENT')),
    Name VARCHAR(10),
    Title VARCHAR(15),
    Info VARCHAR(100)
    );

-- ---------------------------------------------
-- APPOINTMENT
-- ---------------------------------------------
CREATE TABLE IF NOT EXISTS Appointment
(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Schedule_For DATE NOT NULL,
    PatientID INT NOT NULL,
    DoctorID INT NOT NULL,
    FOREIGN KEY (PatientID) REFERENCES Hospital_Users (UserID),
    FOREIGN KEY (DoctorID) REFERENCES Hospital_Users (UserID)
    );

-- ---------------------------------------------
-- MEDICAL_REPORTS
-- ---------------------------------------------
CREATE TABLE IF NOT EXISTS Medical_Report
(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    PatientID INT NOT NULL,
    DoctorID INT NOT NULL,
    TreatmentID INT,
    Date DATE NOT NULL,
    Diagnosis VARCHAR(1000),
    Prescription VARCHAR(100),
    FOREIGN KEY (PatientID) REFERENCES Hospital_Users (UserID),
    FOREIGN KEY (DoctorID) REFERENCES Hospital_Users (UserID)
    );

-- ---------------------------------------------
-- TREATMENT
-- ---------------------------------------------
CREATE TABLE IF NOT EXISTS Treatment
(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Medical_ReportID INT NOT NULL,
    DepartmentID INT NOT NULL,
    Description VARCHAR(1000),
    FOREIGN KEY (Medical_ReportID) REFERENCES Medical_Report (Medical_ReportID),
    FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID)
    );

-- ---------------------------------------------
-- BRIDGE TABLES
-- ---------------------------------------------

-- ---------------------------------------------
-- DOCTOR - DEPT
-- ---------------------------------------------
CREATE TABLE IF NOT EXISTS Doc_Dep
(
    DepartmentID INT NOT NULL,
    DoctorID INT NOT NULL,
    FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID),
    FOREIGN KEY (DoctorID) REFERENCES Hospital_Users (UserID)
    );

-- ---------------------------------------------
-- PATIENT - DEPT
-- ---------------------------------------------
CREATE TABLE IF NOT EXISTS Pat_Dep
(
    DepartmentID INT NOT NULL,
    PatientID INT NOT NULL,
    FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID),
    FOREIGN KEY (PatientID) REFERENCES Hospital_Users (UserID)
    );