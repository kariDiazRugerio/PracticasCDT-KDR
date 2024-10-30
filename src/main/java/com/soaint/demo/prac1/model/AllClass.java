package com.soaint.demo.prac1.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllClass {

    private Root root;
    private Address address;
    private Company company;
    private Geo geo;


    public AllClass() {
    }

    public AllClass(Root root, Address address, Company company, Geo geo) {
        this.root = root;
        this.address = address;
        this.company = company;
        this.geo = geo;
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
