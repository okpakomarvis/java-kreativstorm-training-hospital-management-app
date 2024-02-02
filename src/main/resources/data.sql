insert into department (ID, dapartmentName) values (1, "Cardiology");
insert into department (ID, dapartmentName) values (2, "Surgery");

insert into users (ID, username, password, role, name, title, info)
    values (1, "doc1", "d1pass", "DOCTOR", "One", "dr.med.", "something");
insert into users (ID, username, password, role, name, title, info)
    values (2, "doc2", "d2pass", "DOCTOR", "Two", "dr.med.", "something");
insert into users (ID, username, password, role, name, title, info)
    values (3, "nur1", "n1pass", "NURSE", "One", "nurse", "something");
insert into users (ID, username, password, role, name, title, info)
    values (4, "admin1", "a1pass", "ADMIN", "One", "admin", "something");
insert into users (ID, username, password, role, name, title, info)
    values (5, "pat1", "p1pass", "PATIENT", "One", "mr.", "something");
insert into users (ID, username, password, role, name, title, info)
    values (6, "pat2", "p2pass", "PATIENT", "Two", "mrs.", "something");

insert into treatment (ID, Medical_ReportID, DepartmentID, Description)
values (1, 1, 2, "Some Description");
insert into treatment (ID, Medical_ReportID, DepartmentID, Description)
values (2, 2, 1, "Some Description");

insert into medical_report (id, name, patientId, doctorID, treatmentID, date, diagnosis, prescription)
values (1, "MR1", 5, 1, 1, CURRENT_DATE, "some diagnosis", "some presciption");
insert into medical_report (id, name, patientId, doctorID, treatmentID, date, diagnosis, prescription)
values (2, "MR2", 6, 2, 2, CURRENT_DATE, "some diagnosis", "some presciption");

insert into appointment (ID, Schedule_for, PatientID, DococtorID)
values (1, CURRENT_DATE , 6, 2);
insert into appointment (ID, Schedule_for, PatientID, DococtorID)
values (1, CURRENT_DATE , 5, 1);

