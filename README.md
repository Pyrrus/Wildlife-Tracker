# Wildlife Tracker site using spark, java and postgresql

## This site will uses java and postgresql to save and display your information, 9/30/16

#### By **Adam Gorbahn**

## Description
This made for the wildlife tracker to know are the sightings of the animals in Portland, OR.

## Specifications

#### '/endangeredanimal/new' page

user input                | output
------------------------- | -------------
Type in the endangeredanimal text fields | giving endangeredanimal by the user in the input tag

user input                | output
------------------------- | -------------
click on the "submit" button | This will make the endangeredanimal given by the user. The site will send them to the "/endangeredanimal" page. Update page with new endangeredanimal. 

#### '/animal/new' page

user input                | output
------------------------- | -------------
Type in the animal text fields | giving animal by the user in the input tag

user input                | output
------------------------- | -------------
click on the "submit" button | This will make the animal given by the user. The site will send them to the "/animal" page. Update page with new animal.

#### '/sighting/new' page

user input                | output
------------------------- | -------------
Type in the sighting text fields and pick(s) for Animals | giving sighting by the user in the input tag

user input                | output
------------------------- | -------------
click on the "submit" button | This will make the sighting given by the user. The site will send them to the "/" page. Update two pages with new sighting for the animals.  

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