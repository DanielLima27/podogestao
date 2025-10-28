
CREATE TABLE consent_term (
    id SERIAL PRIMARY KEY,
    patient_name VARCHAR(255),
    cpf VARCHAR(14),
    procedure VARCHAR(255),
    agreement_date DATE,
    client_signature VARCHAR(255)
);

CREATE TABLE dermatological_changes (
    id SERIAL PRIMARY KEY,
    onychomycosis BOOLEAN,
    onychophosis BOOLEAN,
    onycholysis BOOLEAN,
    onychogryphosis BOOLEAN,
    granuloma BOOLEAN,
    onychocryptosis BOOLEAN,
    onychotrophy BOOLEAN,
    onychorrhexis BOOLEAN,
    nail_psoriasis BOOLEAN
);

CREATE TABLE foot_inspection (
    id SERIAL PRIMARY KEY,
    toe_type VARCHAR(50),
    foot_type VARCHAR(50),
    perfusion_type VARCHAR(50),
    dermatological_changes_id INTEGER REFERENCES dermatological_changes(id) ON DELETE CASCADE
);

CREATE TABLE foot_inspection_conditions (
    foot_inspection_id INTEGER REFERENCES foot_inspection(id) ON DELETE CASCADE,
    conditions VARCHAR(50),
    PRIMARY KEY (foot_inspection_id, conditions)
);

CREATE TABLE podological_inspection (
    id SERIAL PRIMARY KEY,
    left_foot_inspection_id INTEGER REFERENCES foot_inspection(id) ON DELETE CASCADE,
    right_foot_inspection_id INTEGER REFERENCES foot_inspection(id) ON DELETE CASCADE,
    dermatological_changes_id INTEGER REFERENCES dermatological_changes(id) ON DELETE CASCADE
);
CREATE TABLE podological_inspection_conditions (
    podological_inspection_id bigint REFERENCES podological_inspection(id),
    condition_id bigint,
    PRIMARY KEY (podological_inspection_id, condition_id)
);


CREATE TABLE professional_observations (
    id SERIAL PRIMARY KEY,
    observation_notes TEXT,
    procedure TEXT,
    date DATE,
    podologist_name VARCHAR(255),
    podological_inspection_id INTEGER REFERENCES podological_inspection(id) ON DELETE CASCADE,
    consent_term_id INTEGER REFERENCES consent_term(id) ON DELETE CASCADE
);

ALTER TABLE medical_history
ADD COLUMN professional_observations_id INTEGER REFERENCES professional_observations(id);
