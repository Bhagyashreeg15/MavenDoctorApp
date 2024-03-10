package org.doctorapp.model;

public enum SpecializationEnum {
        ORTHO("ORTHOPEDIC"),
        PEDIA("PEDIATRICIAN"),
        PHYSICIAN("GENERAL PHYSICIAN"),
        GYNAEC("GYNAECOLOGIST"),
        NEURO("NEUROLOGIST"),
        DERMA("DERMATOLOGIST");

        private String speciality;
        SpecializationEnum(String speciality) {
            this.speciality =speciality;
        }

        public String getSpeciality() {
            return speciality;
        }
    }

