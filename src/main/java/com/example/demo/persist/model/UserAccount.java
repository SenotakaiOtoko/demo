package com.example.demo.persist.model;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

/**
 * Аккаунт пользователя
 */
@ToString
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserAccount {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  String username;
  String password;
  String email;
}
