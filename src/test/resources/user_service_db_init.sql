--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.8
-- Dumped by pg_dump version 10.6

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: uuid-ossp; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;


--
-- Name: EXTENSION "uuid-ossp"; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';


--
-- Name: pgcrypto; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS "pgcrypto" WITH SCHEMA public;


--
-- Name: EXTENSION "pgcrypto"; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION "pgcrypto" IS 'Crypto functions for PostgreSQL';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: databasechangelog; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.databasechangelog (
    id character varying(255) NOT NULL,
    author character varying(255) NOT NULL,
    filename character varying(255) NOT NULL,
    dateexecuted timestamp without time zone NOT NULL,
    orderexecuted integer NOT NULL,
    exectype character varying(10) NOT NULL,
    md5sum character varying(35),
    description character varying(255),
    comments character varying(255),
    tag character varying(255),
    liquibase character varying(20),
    contexts character varying(255),
    labels character varying(255),
    deployment_id character varying(10)
);


--
-- Name: databasechangeloglock; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.databasechangeloglock (
    id integer NOT NULL,
    locked boolean NOT NULL,
    lockgranted timestamp without time zone,
    lockedby character varying(255)
);


--
-- Name: group_permissions; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.group_permissions (
    "group" character varying(40) NOT NULL,
    photo character varying(40) NOT NULL,
    rights bit varying(20)
);


--
-- Name: groups; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.groups (
    id character varying(40) DEFAULT public.uuid_generate_v4() NOT NULL,
    name character varying(50) NOT NULL,
    created timestamp with time zone DEFAULT now() NOT NULL,
    modified timestamp with time zone DEFAULT now() NOT NULL
);


--
-- Name: photo_tags; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.photo_tags (
    photo_id character varying(40) NOT NULL,
    tag_id character varying(40) NOT NULL
);


--
-- Name: photos; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.photos (
    id character varying(40) DEFAULT public.uuid_generate_v4() NOT NULL,
    filename character varying(255) NOT NULL,
    details jsonb,
    owner character varying(40) NOT NULL,
    created timestamp with time zone DEFAULT now() NOT NULL,
    modified timestamp with time zone DEFAULT now() NOT NULL
);


--
-- Name: tags; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tags (
    id character varying(40) NOT NULL,
    tag character varying(255) NOT NULL
);


--
-- Name: user_groups; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.user_groups (
    "user" character varying(40) NOT NULL,
    "group" character varying(40) NOT NULL
);


--
-- Name: user_permissions; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.user_permissions (
    "user" character varying(40) NOT NULL,
    photo character varying(40) NOT NULL,
    rights bit varying(20)
);


--
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.users (
    id character varying(40) DEFAULT public.uuid_generate_v4() NOT NULL,
    username character varying(50) NOT NULL,
    given_name character varying(50),
    family_name character varying(50) NOT NULL,
    password character varying(50),
    created timestamp with time zone DEFAULT now() NOT NULL,
    modified timestamp with time zone DEFAULT now() NOT NULL
);

INSERT INTO users (username, given_name, family_name, password) VALUES ('dphillips', 'Deven', 'Phillips', )


--
-- Data for Name: databasechangelog; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.databasechangelog VALUES ('1', 'dphillips', 'db/changeLog.yaml', '2019-01-03 09:54:52.925875', 1, 'EXECUTED', '8:47c30c13acd7bf79fa4fa530edc1fb09', 'sql', 'Enable uuid-ossp extension', NULL, '3.6.2', NULL, NULL, '6527292852');
INSERT INTO public.databasechangelog VALUES ('2', 'dphillips', 'db/changeLog.yaml', '2019-01-03 09:54:52.955089', 2, 'EXECUTED', '8:03cad7da5faab8b747e3a7d10b09fb8e', 'createTable tableName=users; createTable tableName=groups; createTable tableName=user_groups', '', NULL, '3.6.2', NULL, NULL, '6527292852');
INSERT INTO public.databasechangelog VALUES ('3', 'dphillips', 'db/changeLog.yaml', '2019-01-03 09:54:52.97476', 3, 'EXECUTED', '8:dfe1c43402726d81c6bd6394b937574f', 'createTable tableName=photos; addForeignKeyConstraint baseTableName=photos, constraintName=photo_owner_fk, referencedTableName=users', 'Create photos table', NULL, '3.6.2', NULL, NULL, '6527292852');
INSERT INTO public.databasechangelog VALUES ('4', 'dphillips', 'db/changeLog.yaml', '2019-01-03 09:54:52.996545', 4, 'EXECUTED', '8:dfe4cb4cb6e4cef832104f89b57b70fe', 'createTable tableName=user_permissions; addForeignKeyConstraint baseTableName=user_permissions, constraintName=user_permissions_user_fk, referencedTableName=users; addForeignKeyConstraint baseTableName=user_permissions, constraintName=user_permiss...', 'Create permissions schema for data', NULL, '3.6.2', NULL, NULL, '6527292852');
INSERT INTO public.databasechangelog VALUES ('5', 'dphillips', 'db/changeLog.yaml', '2019-01-03 09:54:53.023216', 5, 'EXECUTED', '8:40477601b70f41155c08abb2f61c8f2e', 'createTable tableName=tags; createTable tableName=photo_tags; addPrimaryKey constraintName=photo_tag_pk, tableName=photo_tags; addForeignKeyConstraint baseTableName=photo_tags, constraintName=photo_tags_photo_fk, referencedTableName=photos; addFor...', 'Add schema for tagging photos', NULL, '3.6.2', NULL, NULL, '6527292852');


--
-- Data for Name: databasechangeloglock; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.databasechangeloglock VALUES (1, false, NULL, NULL);


--
-- Data for Name: group_permissions; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: photo_tags; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: photos; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: tags; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: user_groups; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: user_permissions; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Name: databasechangeloglock databasechangeloglock_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.databasechangeloglock
    ADD CONSTRAINT databasechangeloglock_pkey PRIMARY KEY (id);


--
-- Name: groups groups_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.groups
    ADD CONSTRAINT groups_pkey PRIMARY KEY (id);


--
-- Name: photo_tags photo_tag_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.photo_tags
    ADD CONSTRAINT photo_tag_pk PRIMARY KEY (photo_id, tag_id);


--
-- Name: photos photos_id_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.photos
    ADD CONSTRAINT photos_id_key UNIQUE (id);


--
-- Name: tags tags_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tags
    ADD CONSTRAINT tags_pkey PRIMARY KEY (id);


--
-- Name: tags tags_tag_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tags
    ADD CONSTRAINT tags_tag_key UNIQUE (tag);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: group_permissions group_permissions_photo_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.group_permissions
    ADD CONSTRAINT group_permissions_photo_fk FOREIGN KEY (photo) REFERENCES public.photos(id) ON UPDATE RESTRICT;


--
-- Name: group_permissions group_permissions_user_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.group_permissions
    ADD CONSTRAINT group_permissions_user_fk FOREIGN KEY ("group") REFERENCES public.groups(id) ON UPDATE RESTRICT;


--
-- Name: photos photo_owner_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.photos
    ADD CONSTRAINT photo_owner_fk FOREIGN KEY (owner) REFERENCES public.users(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: photo_tags photo_tags_photo_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.photo_tags
    ADD CONSTRAINT photo_tags_photo_fk FOREIGN KEY (photo_id) REFERENCES public.photos(id) ON UPDATE RESTRICT;


--
-- Name: photo_tags photo_tags_tag_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.photo_tags
    ADD CONSTRAINT photo_tags_tag_fk FOREIGN KEY (tag_id) REFERENCES public.tags(id) ON UPDATE RESTRICT;


--
-- Name: user_permissions user_permissions_photo_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.user_permissions
    ADD CONSTRAINT user_permissions_photo_fk FOREIGN KEY (photo) REFERENCES public.photos(id) ON UPDATE RESTRICT;


--
-- Name: user_permissions user_permissions_user_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.user_permissions
    ADD CONSTRAINT user_permissions_user_fk FOREIGN KEY ("user") REFERENCES public.users(id) ON UPDATE RESTRICT;


--
-- PostgreSQL database dump complete
--

