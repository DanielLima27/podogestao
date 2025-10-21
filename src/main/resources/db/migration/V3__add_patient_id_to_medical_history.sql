ALTER TABLE medical_history
ADD COLUMN patient_id BIGINT;

ALTER TABLE medical_history
ADD CONSTRAINT fk_medical_history_patient
FOREIGN KEY (patient_id) REFERENCES patients(id);