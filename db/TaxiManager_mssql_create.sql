CREATE TABLE [street] (
	id integer NOT NULL IDENTITY(1,1) PRIMARY KEY,
	name varchar(128) NOT NULL,
	id_district integer NULL,
  

)
GO
CREATE TABLE [district] (
	id integer NOT NULL IDENTITY(1,1) PRIMARY KEY,
	name varchar(128) NOT NULL,
  

)
GO
CREATE TABLE [client] (
	id integer NOT NULL IDENTITY(1,1) PRIMARY KEY,
	first_name varchar(128) NOT NULL,
	second_name varchar(128) NOT NULL,
	 patronymic varchar(128) NOT NULL,
	phone_number varchar(128) NOT NULL,
	id_discount integer NULL,
 

)
GO
CREATE TABLE [driver] (
	id integer NOT NULL IDENTITY(1,1) PRIMARY KEY,
	first_name varchar(128) NOT NULL,
	second_name varchar(128) NOT NULL,
	 patronymic varchar(128) NOT NULL,
	phone_number varchar(128) NOT NULL,
	date_of_birth datetime NOT NULL,
	date_of_employment datetime NOT NULL,
	category integer NOT NULL,
	id_district integer  NULL,
	id_car integer  NULL,
  

)
GO
CREATE TABLE [status] (
	id integer NOT NULL IDENTITY(1,1) PRIMARY KEY,
	status varchar(64) NOT NULL,
 

)
GO
CREATE TABLE [booking] (
	id integer NOT NULL IDENTITY(1,1) PRIMARY KEY,
	phone_number varchar(64) NOT NULL,
	id_client integer  NULL,
	id_status integer  NULL,
	date_order datetime NOT NULL,
	start_value integer NOT NULL,
	end_value integer NOT NULL,
	id_application_user integer  NULL,
	id_street_from integer  NULL,
	id_street_to integer  NULL,
	id_driver integer  NULL,
  

)
GO
CREATE TABLE [discount] (
	id integer NOT NULL IDENTITY(1,1) PRIMARY KEY,
	name varchar(64) NOT NULL,
	discount_percent integer NOT NULL,
 

)
GO
CREATE TABLE [car] (
	id integer NOT NULL IDENTITY(1,1) PRIMARY KEY,
	name varchar(128) NOT NULL,
	id_brand integer  NULL,
	id_type integer  NULL,
	place integer NOT NULL,
	gos_number varchar(128) NOT NULL,
	stars integer NOT NULL,
	active bit NOT NULL,
  

)
GO
CREATE TABLE [application_user] (
	id integer NOT NULL IDENTITY(1,1) PRIMARY KEY,
	email varchar(256) NOT NULL,
	email_confirmed bit NOT NULL,
	password_hash varchar(max) NOT NULL,
	phone_number varchar(64) NOT NULL,
	phone_number_confirmed bit NOT NULL,
	user_name varchar(256) NOT NULL,
  

)
GO
CREATE TABLE [brand] (
	id integer NOT NULL IDENTITY(1,1) PRIMARY KEY,
	name varchar(128) NOT NULL,
 

)
GO
CREATE TABLE [type_car] (
	id integer NOT NULL IDENTITY(1,1) PRIMARY KEY,
	type varchar(128) NOT NULL,

)

CREATE TABLE logs
   (USER_ID VARCHAR(20)    NOT NULL,
    DATED   DATE           NOT NULL,
    LOGGER  VARCHAR(50)    NOT NULL,
    LEVEL   VARCHAR(10)    NOT NULL,
    MESSAGE VARCHAR(1000)  NOT NULL
   );

GO
ALTER TABLE [street] WITH CHECK ADD CONSTRAINT [street_fk0] FOREIGN KEY ([id_district]) REFERENCES [district]([id])  ON DELETE SET NULL
ON UPDATE CASCADE
GO
ALTER TABLE [street] CHECK CONSTRAINT [street_fk0]
GO


ALTER TABLE [client] WITH CHECK ADD CONSTRAINT [client_fk0] FOREIGN KEY ([id_discount]) REFERENCES [discount]([id])  ON DELETE SET NULL
ON UPDATE CASCADE
GO
ALTER TABLE [client] CHECK CONSTRAINT [client_fk0]
GO

ALTER TABLE [driver] WITH CHECK ADD CONSTRAINT [driver_fk0] FOREIGN KEY ([id_district]) REFERENCES [district]([id])  ON DELETE SET NULL
ON UPDATE CASCADE
GO
ALTER TABLE [driver] CHECK CONSTRAINT [driver_fk0]
GO
ALTER TABLE [driver] WITH CHECK ADD CONSTRAINT [driver_fk1] FOREIGN KEY ([id_car]) REFERENCES [car]([id] )  ON DELETE SET NULL
ON UPDATE CASCADE
GO
ALTER TABLE [driver] CHECK CONSTRAINT [driver_fk1]
GO


ALTER TABLE [booking] WITH CHECK ADD CONSTRAINT [booking_fk0] FOREIGN KEY ([id_client]) REFERENCES [client]([id])  ON DELETE SET NULL
ON UPDATE CASCADE
GO
ALTER TABLE [booking] CHECK CONSTRAINT [booking_fk0]
GO
ALTER TABLE [booking] WITH CHECK ADD CONSTRAINT [booking_fk1] FOREIGN KEY ([id_status]) REFERENCES [status]([id])  ON DELETE SET NULL
ON UPDATE CASCADE
GO
ALTER TABLE [booking] CHECK CONSTRAINT [booking_fk1]
GO
ALTER TABLE [booking] WITH CHECK ADD CONSTRAINT [booking_fk2] FOREIGN KEY ([id_application_user]) REFERENCES [application_user]([id])  ON DELETE SET NULL
ON UPDATE CASCADE
GO
ALTER TABLE [booking] CHECK CONSTRAINT [booking_fk2]
GO
ALTER TABLE [booking] WITH CHECK ADD CONSTRAINT [booking_fk3] FOREIGN KEY ([id_street_from]) REFERENCES [street]([id])  ON DELETE SET NULL
ON UPDATE CASCADE
GO
ALTER TABLE [booking] CHECK CONSTRAINT [booking_fk3]
GO
ALTER TABLE [booking] WITH CHECK ADD CONSTRAINT [booking_fk4] FOREIGN KEY ([id_street_to]) REFERENCES [street]([id])  ON DELETE SET NULL
ON UPDATE CASCADE
GO
ALTER TABLE [booking] CHECK CONSTRAINT [booking_fk4]
GO
ALTER TABLE [booking] WITH CHECK ADD CONSTRAINT [booking_fk5] FOREIGN KEY ([id_driver]) REFERENCES [driver]([id])  ON DELETE SET NULL
ON UPDATE CASCADE
GO
ALTER TABLE [booking] CHECK CONSTRAINT [booking_fk5]
GO


ALTER TABLE [car] WITH CHECK ADD CONSTRAINT [car_fk0] FOREIGN KEY ([id_brand]) REFERENCES [brand]([id])  ON DELETE SET NULL
ON UPDATE CASCADE
GO
ALTER TABLE [car] CHECK CONSTRAINT [car_fk0]
GO
ALTER TABLE [car] WITH CHECK ADD CONSTRAINT [car_fk1] FOREIGN KEY ([id_type]) REFERENCES [type_car]([id])  ON DELETE SET NULL
ON UPDATE CASCADE
GO
ALTER TABLE [car] CHECK CONSTRAINT [car_fk1]
GO



