CREATE TABLE contact_info
(
    id             UUID PRIMARY KEY,
    street_address VARCHAR(255),
    city           VARCHAR(255),
    state          VARCHAR(255),
    zip_code       VARCHAR(255),
    country        VARCHAR(255),
    phone_number   VARCHAR(255),
    email          VARCHAR(255),
    website        VARCHAR(255),
    linkedin       VARCHAR(255),
    github         VARCHAR(255)
);

CREATE TABLE companies
(
    id              UUID PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    contact_info_id UUID UNIQUE REFERENCES contact_info (id), -- One-to-one relationship with contact_info
    industry        VARCHAR(255),
    size            VARCHAR(255)
);

CREATE TABLE education
(
    id              UUID PRIMARY KEY,
    school_name     VARCHAR(255) NOT NULL,
    degree          VARCHAR(255),
    major           VARCHAR(255),
    minor           VARCHAR(255),
    gpa             BIGINT,
    contact_info_id UUID REFERENCES contact_info (id), -- Foreign key to contact_info
    start_date      DATE,
    end_date        DATE
);

CREATE TABLE work_experience
(
    id         UUID PRIMARY KEY,
    company_id UUID REFERENCES companies (id), -- Foreign key to companies table
    title      VARCHAR(255),
    location   VARCHAR(255),
    start_date DATE NOT NULL,
    end_date   DATE,
    department VARCHAR(255)
);

CREATE TABLE skills
(
    id                 UUID PRIMARY KEY,
    name               VARCHAR(255) NOT NULL,
    type               VARCHAR(255) NOT NULL,
    proficiency        VARCHAR(255),
    years_experience   INT,
    work_experience_id UUID REFERENCES work_experience (id) -- Foreign key to work_experience
);

CREATE TABLE experience_summary
(
    id                 UUID PRIMARY KEY,
    company_id         UUID REFERENCES companies (id),      -- Foreign key to companies table
    order_number       INT,
    summary            TEXT,                                -- Using TEXT for potentially longer summary descriptions
    achievement        BOOLEAN,
    work_experience_id UUID REFERENCES work_experience (id) -- Foreign key to work_experience
);