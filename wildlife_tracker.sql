--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6rc1
-- Dumped by pg_dump version 9.6rc1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: animals; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE animals (
    id integer NOT NULL,
    name character varying,
    type boolean
);


ALTER TABLE animals OWNER TO postgres;

--
-- Name: animals_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE animals_id_seq OWNER TO postgres;

--
-- Name: animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE animals_id_seq OWNED BY animals.id;


--
-- Name: endaneredinfos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE endaneredinfos (
    id integer NOT NULL,
    animal_id integer,
    health character varying,
    age character varying
);


ALTER TABLE endaneredinfos OWNER TO postgres;

--
-- Name: endaneredinfos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE endaneredinfos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE endaneredinfos_id_seq OWNER TO postgres;

--
-- Name: endaneredinfos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE endaneredinfos_id_seq OWNED BY endaneredinfos.id;


--
-- Name: sightings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE sightings (
    id integer NOT NULL,
    location text,
    rangername character varying,
    lastsee timestamp without time zone,
    animal_id integer
);


ALTER TABLE sightings OWNER TO postgres;

--
-- Name: sightings_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sightings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sightings_id_seq OWNER TO postgres;

--
-- Name: sightings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sightings_id_seq OWNED BY sightings.id;


--
-- Name: animals id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY animals ALTER COLUMN id SET DEFAULT nextval('animals_id_seq'::regclass);


--
-- Name: endaneredinfos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endaneredinfos ALTER COLUMN id SET DEFAULT nextval('endaneredinfos_id_seq'::regclass);


--
-- Name: sightings id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sightings ALTER COLUMN id SET DEFAULT nextval('sightings_id_seq'::regclass);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY animals (id, name, type) FROM stdin;
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('animals_id_seq', 1, false);


--
-- Data for Name: endaneredinfos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY endaneredinfos (id, animal_id, health, age) FROM stdin;
\.


--
-- Name: endaneredinfos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('endaneredinfos_id_seq', 1, false);


--
-- Data for Name: sightings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sightings (id, location, rangername, lastsee, animal_id) FROM stdin;
\.


--
-- Name: sightings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sightings_id_seq', 1, false);


--
-- Name: animals animals_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);


--
-- Name: endaneredinfos endaneredinfos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endaneredinfos
    ADD CONSTRAINT endaneredinfos_pkey PRIMARY KEY (id);


--
-- Name: sightings sightings_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sightings
    ADD CONSTRAINT sightings_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

