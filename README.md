# site using spark, java and postgresql

## , 9/30/16

#### By **Adam Gorbahn**

## Description


## User Stories


## Specifications



## Setup/Installation Requirements

* need java, gradle, spark, and Postgresql.

## code

The sql file is in the folder call SQL


```
In Postgresql:

create database wildlife_tracker;
create table animals (id serial PRIMARY KEY, name varchar, type boolean);
create table endaneredinfos (id serial PRIMARY KEY, animal_id int, health varchar, age varchar);
create table sightings (id serial PRIMARY KEY, location text, rangerName varchar, lastsee timestamp, animal_id int);

create database wildlife_tracker_test;
create table animals (id serial PRIMARY KEY, name varchar, type boolean);
create table endaneredinfos (id serial PRIMARY KEY, animal_id int, health varchar, age varchar);
create table sightings (id serial PRIMARY KEY, location text, rangerName varchar, lastsee timestamp, animal_id int);

```

## Technologies Used

* HTML
* Java
* Spark
* Juint
* Gradle
* Postgresql

### License

*GPL*

Copyright (c) 2016 **Adam Gorbahn**