package com.sigma.qsab.data;

public class Customer {

    private String firstName;
    private String lastName;
    private String socialID;
    private String street;
    private String zipCode;
    private String city;
    private String phone;
    private String cellPhone;
    private String email;
    private String password;

    public Customer(String firstName, String lastName, String socialID, String street, String zipCode, String city, String phone, String cellPhone, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialID = socialID;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.phone = phone;
        this.cellPhone = cellPhone;
        this.email = email;
        this.password = password;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getSocialID() {
        return socialID;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if ((this.firstName == null) ? (other.firstName != null) : !this.firstName.equals(other.firstName)) {
            return false;
        }
        if ((this.lastName == null) ? (other.lastName != null) : !this.lastName.equals(other.lastName)) {
            return false;
        }
        if ((this.socialID == null) ? (other.socialID != null) : !this.socialID.equals(other.socialID)) {
            return false;
        }
        if ((this.street == null) ? (other.street != null) : !this.street.equals(other.street)) {
            return false;
        }
        if ((this.zipCode == null) ? (other.zipCode != null) : !this.zipCode.equals(other.zipCode)) {
            return false;
        }
        if ((this.city == null) ? (other.city != null) : !this.city.equals(other.city)) {
            return false;
        }
        if ((this.phone == null) ? (other.phone != null) : !this.phone.equals(other.phone)) {
            return false;
        }
        if ((this.cellPhone == null) ? (other.cellPhone != null) : !this.cellPhone.equals(other.cellPhone)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 89 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 89 * hash + (this.socialID != null ? this.socialID.hashCode() : 0);
        hash = 89 * hash + (this.street != null ? this.street.hashCode() : 0);
        hash = 89 * hash + (this.zipCode != null ? this.zipCode.hashCode() : 0);
        hash = 89 * hash + (this.city != null ? this.city.hashCode() : 0);
        hash = 89 * hash + (this.phone != null ? this.phone.hashCode() : 0);
        hash = 89 * hash + (this.cellPhone != null ? this.cellPhone.hashCode() : 0);
        hash = 89 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 89 * hash + (this.password != null ? this.password.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();        
        sb.append("Customer: ").append(getSocialID()).append('\n');
        sb.append("Name: ").append(getFirstName()).append(' ').append(getLastName()).append('\n');
        sb.append("Address: ").append(getStreet()).append(", ").append(getZipCode()).append(' ').append(getCity()).append('\n');
        sb.append("Phone numbers: ").append(getPhone()).append(", ").append(getCellPhone()).append('\n');
        sb.append("Email: ").append(getEmail()).append('\n');
        return sb.toString ();
    }
}
