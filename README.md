# SpringBoot-CRUD


A Spring REST API application with JPA (PostgreSQL) and Docker, built for learning purposes.
Overview

This project is a simple CRUD (Create, Read, Update, Delete) application built using Spring Boot, JPA, and PostgreSQL. It demonstrates the basic concepts of building a RESTful API with Spring Boot and Docker.
Technologies Used

    Spring Web
    Spring JPA
    PostgreSQL JDBC Driver
    Docker
    Docker Compose (with PostgreSQL and Adminer)

## Database Schema

The application uses two tables: student and department.

### Student Table

    id (primary key)
    name
    department_id (foreign key referencing the department table)

### Department Table

    id (primary key)
    name

## Application Structure

The application is structured as follows:

    Student and Department entities with corresponding repositories and services
    StudentDTO for data transfer
    StudentController and DepartmentController for handling REST requests

## Features

    CRUD operations for Student and Department entities
    Dockerized PostgreSQL database with Adminer for easy database management

## Purpose

This project was built as an introduction to Spring Boot and Docker, and to demonstrate the basics of building a RESTful API with JPA and PostgreSQL.

**Feel free to modify and improve the code as you see fit!**