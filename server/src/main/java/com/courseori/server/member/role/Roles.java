//package com.courseori.server.member.role;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.validation.constraints.NotBlank;
//import java.util.Date;
//
//@Data
//@Entity
//@NoArgsConstructor
//public class Roles {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int roleId;
//
//    @NotBlank
//    private String role;
//
//    private Date createdAt = new Date();
//    private Date modifiedAt = new Date();
//
//    public Roles(String role) {
//        this.role = role;
//    }
//
//    public Roles(int roleId, String role) {
//        this.roleId = roleId;
//        this.role = role;
//    }
//}
