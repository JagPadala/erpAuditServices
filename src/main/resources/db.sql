CREATE DATABASE "ERP_AUDIT"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

    CREATE SCHEMA "ERP_AUDIT"
        AUTHORIZATION postgres;

        CREATE TABLE "ERP_AUDIT"."USER"
        (
            "ID" text NOT NULL,
            "Name" text NOT NULL,
            "DESCRIPTION" text,
            "DEPARTMENT" text,
            "STATUS" text NOT NULL,
            "CREATION_DATE" date NOT NULL,
            "INACTIVE_DATE" date,
            PRIMARY KEY ("ID")
        );

        ALTER TABLE IF EXISTS "ERP_AUDIT"."USER"
            OWNER to postgres;

 CREATE TABLE IF NOT EXISTS "ERP_AUDIT"."ROLES"
 (
     "ID" text COLLATE pg_catalog."default" NOT NULL,
     "NAME" text COLLATE pg_catalog."default" NOT NULL,
     "DESCRIPTION" text COLLATE pg_catalog."default",
     "FROM_SYSTEM" text COLLATE pg_catalog."default",
     "CREATION_DATE" date,
     "SENSITIVE_FLAG" boolean,
     CONSTRAINT "ROLES_pkey" PRIMARY KEY ("ID")
 )

 TABLESPACE pg_default;

 ALTER TABLE IF EXISTS "ERP_AUDIT"."ROLES"
     OWNER to postgres;

 CREATE TABLE "ERP_AUDIT"."PRIVILIEGES"
 (
     "ID" text NOT NULL,
     "NAME" text NOT NULL,
     "DESCRIPTION" text,
     "SENSITIVE_FLAG" boolean DEFAULT false,
     "ROLE_ASSIGN_DATE" date NOT NULL,
     "ROLE_ID" text NOT NULL,
     PRIMARY KEY ("ID"),
     CONSTRAINT "ROLE_ID" FOREIGN KEY ("ROLE_ID")
         REFERENCES "ERP_AUDIT"."ROLES" ("ID") MATCH SIMPLE
         ON UPDATE NO ACTION
         ON DELETE NO ACTION
         NOT VALID
 );

 ALTER TABLE IF EXISTS "ERP_AUDIT"."PRIVILIEGES"
     OWNER to postgres;

 CREATE TABLE "ERP_AUDIT"."USER_ACTIONS"
 (
     "ID" text NOT NULL,
     "ACTION_TYPE" text,
     "ACTION_OBJECT" text,
     "AFTER_VALUES" json,
     "BEFORE_VALUES" json,
     "USER_ID" text NOT NULL,
     PRIMARY KEY ("ID"),
     CONSTRAINT "USER_ACTIONS" FOREIGN KEY ("USER_ID")
         REFERENCES "ERP_AUDIT"."USER" ("ID") MATCH SIMPLE
         ON UPDATE NO ACTION
         ON DELETE NO ACTION
         NOT VALID
 );

 ALTER TABLE IF EXISTS "ERP_AUDIT"."USER_ACTIONS"
     OWNER to postgres;