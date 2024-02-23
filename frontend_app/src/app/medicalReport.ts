export interface MedicalReport {
  name: string;
  patientID: number;
  doctorID: number;
  treatmentID: number | undefined;
  date: number;
  diagnosis: string;
  prescription: string;
}
