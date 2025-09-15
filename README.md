# HospitalManagementProjectSpringBoot
The Hospital Management System (HMS) is a software solution designed to manage and streamline hospital operations. It provides digital management of doctors, patients, appointments, and billing, ensuring efficient workflows and reducing paperwork
Hospital Management System – API Documentation

Base URL:
/api/v1

---------------------------------------------------
Doctor API (/api/v1/doctor)

Entity Fields:
- id (Integer, Auto-generated)
- name (String)
- specialization (String)
- phone (String)
- email (String)

Endpoints:
- POST /api/v1/doctor → Create a new doctor
- GET /api/v1/doctor → Get all doctors
- GET /api/v1/doctor/{id} → Get doctor by ID
- PUT /api/v1/doctor/{id} → Update doctor by ID
- DELETE /api/v1/doctor/{id} → Delete doctor by ID

---------------------------------------------------
Patient API (/api/v1/patient)

Entity Fields:
- id (Integer, Auto-generated)
- name (String)
- age (Integer)
- gender (String)
- phone (String)
- address (String)

Endpoints:
- POST /api/v1/patient → Create a new patient
- GET /api/v1/patient → Get all patients
- GET /api/v1/patient/{id} → Get patient by ID
- PUT /api/v1/patient/{id} → Update patient by ID
- DELETE /api/v1/patient/{id} → Delete patient by ID

---------------------------------------------------
Appointment API (/api/v1/appointment)

Entity Fields:
- id (Integer, Auto-generated)
- doctorId (Integer, Foreign Key → Doctor)
- patientId (Integer, Foreign Key → Patient)
- appointmentDate (DateTime)
- status (String → Scheduled, Completed, Cancelled)

Endpoints:
- POST /api/v1/appointment → Create a new appointment
- GET /api/v1/appointment → Get all appointments
- GET /api/v1/appointment/{id} → Get appointment by ID
- PUT /api/v1/appointment/{id} → Update appointment by ID
- DELETE /api/v1/appointment/{id} → Delete appointment by ID

---------------------------------------------------
Bill API (/api/v1/bill)

Entity Fields:
- id (Integer, Auto-generated)
- patientId (Integer, Foreign Key → Patient)
- appointmentId (Integer, Foreign Key → Appointment)
- amount (Decimal/Integer)
- paymentStatus (String → Paid, Pending, Cancelled)

Endpoints:
- POST /api/v1/bill → Create a new bill
- GET /api/v1/bill → Get all bills
- GET /api/v1/bill/{id} → Get bill by ID
- PUT /api/v1/bill/{id} → Update bill by ID
- DELETE /api/v1/bill/{id} → Delete bill by ID
