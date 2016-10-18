CREATE TABLE "street" (
	"id" serial NOT NULL,
	"name" varchar(128) NOT NULL,
	"id_district" integer NOT NULL,
	CONSTRAINT street_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "district" (
	"id" serial NOT NULL,
	"name" varchar(128) NOT NULL,
	CONSTRAINT district_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "location_order" (
	"id" integer UNIQUE,
	"phone_number" varchar(64) NOT NULL,
	"date_order" TIME NOT NULL,
	"date_come_from" TIME NOT NULL,
	"date_come_to" TIME NOT NULL,
	"id_street_from" integer NOT NULL,
	"address_from" varchar(256) NOT NULL,
	"address_to" varchar(256) NOT NULL,
	"id_street_to" integer NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE "client" (
	"id" serial NOT NULL,
	"first_name" varchar(128) NOT NULL,
	"second_name" varchar(128) NOT NULL,
	" patronymic" varchar(128) NOT NULL,
	"phone_number" varchar(128) NOT NULL,
	"id_discount" integer NOT NULL,
	CONSTRAINT client_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "driver" (
	"id" serial NOT NULL,
	"first_name" varchar(128) NOT NULL,
	"second_name" varchar(128) NOT NULL,
	" patronymic" varchar(128) NOT NULL,
	"phone_number" varchar(128) NOT NULL,
	"date_of_birth" DATE NOT NULL,
	"date_of_employment" DATE NOT NULL,
	"category" integer NOT NULL,
	"id_district" integer NOT NULL,
	"id_car" integer NOT NULL,
	CONSTRAINT driver_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "value_taximeter" (
	"id" integer UNIQUE,
	"start_value" integer NOT NULL,
	"end_value" integer NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE "status" (
	"id" serial NOT NULL,
	"status" varchar(64) NOT NULL,
	CONSTRAINT status_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "order" (
	"id" serial NOT NULL,
	"id_client" integer NOT NULL,
	"id_driver" integer NOT NULL,
	"id_status" integer NOT NULL,
	"id_application_user" integer NOT NULL,
	CONSTRAINT order_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "discount" (
	"id" serial NOT NULL,
	"name" varchar(64) NOT NULL,
	"discount_percent" serial NOT NULL,
	CONSTRAINT discount_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "car" (
	"id" serial NOT NULL,
	"name" varchar(128) NOT NULL,
	"id_brand" integer NOT NULL,
	"id_type" integer NOT NULL,
	"place" integer NOT NULL,
	"gos_number" varchar(128) NOT NULL,
	"stars" integer NOT NULL,
	"active" boolean NOT NULL,
	CONSTRAINT car_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "application_user" (
	"id" serial NOT NULL,
	"email" varchar(256) NOT NULL,
	"email_confirmed" boolean NOT NULL,
	"password_hash" varchar NOT NULL,
	"phone_number" varchar NOT NULL,
	"phone_number_confirmed" boolean NOT NULL,
	"user_name" varchar NOT NULL,
	CONSTRAINT application_user_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "brand" (
	"id" serial NOT NULL,
	"name" varchar(128) NOT NULL,
	CONSTRAINT brand_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "type_car" (
	"id" serial NOT NULL,
	"type" varchar(128) NOT NULL,
	CONSTRAINT type_car_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



ALTER TABLE "street" ADD CONSTRAINT "street_fk0" FOREIGN KEY ("id_district") REFERENCES "district"("id");


ALTER TABLE "location_order" ADD CONSTRAINT "location_order_fk0" FOREIGN KEY ("id") REFERENCES "order"("id");
ALTER TABLE "location_order" ADD CONSTRAINT "location_order_fk1" FOREIGN KEY ("id_street_from") REFERENCES "street"("id");
ALTER TABLE "location_order" ADD CONSTRAINT "location_order_fk2" FOREIGN KEY ("id_street_to") REFERENCES "street"("id");

ALTER TABLE "client" ADD CONSTRAINT "client_fk0" FOREIGN KEY ("id_discount") REFERENCES "discount"("id");

ALTER TABLE "driver" ADD CONSTRAINT "driver_fk0" FOREIGN KEY ("id_district") REFERENCES "district"("id");
ALTER TABLE "driver" ADD CONSTRAINT "driver_fk1" FOREIGN KEY ("id_car") REFERENCES "car"("id");

ALTER TABLE "value_taximeter" ADD CONSTRAINT "value_taximeter_fk0" FOREIGN KEY ("id") REFERENCES "order"("id");


ALTER TABLE "order" ADD CONSTRAINT "order_fk0" FOREIGN KEY ("id_client") REFERENCES "client"("id");
ALTER TABLE "order" ADD CONSTRAINT "order_fk1" FOREIGN KEY ("id_driver") REFERENCES "driver"("id");
ALTER TABLE "order" ADD CONSTRAINT "order_fk2" FOREIGN KEY ("id_status") REFERENCES "status"("id");
ALTER TABLE "order" ADD CONSTRAINT "order_fk3" FOREIGN KEY ("id_application_user") REFERENCES "application_user"("id");


ALTER TABLE "car" ADD CONSTRAINT "car_fk0" FOREIGN KEY ("id_brand") REFERENCES "brand"("id");
ALTER TABLE "car" ADD CONSTRAINT "car_fk1" FOREIGN KEY ("id_type") REFERENCES "type_car"("id");




