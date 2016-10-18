CREATE TABLE [street] (
	id integer NOT NULL,
	name varchar(128) NOT NULL,
	id_district integer NOT NULL,
  CONSTRAINT [PK_STREET] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [district] (
	id integer NOT NULL,
	name varchar(128) NOT NULL,
  CONSTRAINT [PK_DISTRICT] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [location_order] (
	id integer UNIQUE,
	phone_number varchar(64) NOT NULL,
	date_order datetime NOT NULL,
	date_come_from datetime NOT NULL,
	date_come_to datetime NOT NULL,
	id_street_from integer NOT NULL,
	address_from varchar(256) NOT NULL,
	address_to varchar(256) NOT NULL,
	id_street_to integer NOT NULL
)
GO
CREATE TABLE [client] (
	id integer NOT NULL,
	first_name varchar(128) NOT NULL,
	second_name varchar(128) NOT NULL,
	 patronymic varchar(128) NOT NULL,
	phone_number varchar(128) NOT NULL,
	id_discount integer NOT NULL,
  CONSTRAINT [PK_CLIENT] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [driver] (
	id integer NOT NULL,
	first_name varchar(128) NOT NULL,
	second_name varchar(128) NOT NULL,
	 patronymic varchar(128) NOT NULL,
	phone_number varchar(128) NOT NULL,
	date_of_birth date NOT NULL,
	date_of_employment date NOT NULL,
	category integer NOT NULL,
	id_district integer NOT NULL,
	id_car integer NOT NULL,
  CONSTRAINT [PK_DRIVER] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [value_taximeter] (
	id integer UNIQUE,
	start_value integer NOT NULL,
	end_value integer NOT NULL
)
GO
CREATE TABLE [status] (
	id integer NOT NULL,
	status varchar(64) NOT NULL,
  CONSTRAINT [PK_STATUS] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [order] (
	id integer NOT NULL,
	id_client integer NOT NULL,
	id_driver integer NOT NULL,
	id_status integer NOT NULL,
	id_application_user integer NOT NULL,
  CONSTRAINT [PK_ORDER] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [discount] (
	id integer NOT NULL,
	name varchar(64) NOT NULL,
	discount_percent integer NOT NULL,
  CONSTRAINT [PK_DISCOUNT] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [car] (
	id integer NOT NULL,
	name varchar(128) NOT NULL,
	id_brand integer NOT NULL,
	id_type integer NOT NULL,
	place integer NOT NULL,
	gos_number varchar(128) NOT NULL,
	stars integer NOT NULL,
	active binary NOT NULL,
  CONSTRAINT [PK_CAR] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [application_user] (
	id integer NOT NULL,
	email varchar(256) NOT NULL,
	email_confirmed binary NOT NULL,
	password_hash varchar NOT NULL,
	phone_number varchar NOT NULL,
	phone_number_confirmed binary NOT NULL,
	user_name varchar NOT NULL,
  CONSTRAINT [PK_APPLICATION_USER] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [brand] (
	id integer NOT NULL,
	name varchar(128) NOT NULL,
  CONSTRAINT [PK_BRAND] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [type_car] (
	id integer NOT NULL,
	type varchar(128) NOT NULL,
  CONSTRAINT [PK_TYPE_CAR] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
ALTER TABLE [street] WITH CHECK ADD CONSTRAINT [street_fk0] FOREIGN KEY ([id_district]) REFERENCES [district]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [street] CHECK CONSTRAINT [street_fk0]
GO


ALTER TABLE [location_order] WITH CHECK ADD CONSTRAINT [location_order_fk0] FOREIGN KEY ([id]) REFERENCES [order]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [location_order] CHECK CONSTRAINT [location_order_fk0]
GO
ALTER TABLE [location_order] WITH CHECK ADD CONSTRAINT [location_order_fk1] FOREIGN KEY ([id_street_from]) REFERENCES [street]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [location_order] CHECK CONSTRAINT [location_order_fk1]
GO
ALTER TABLE [location_order] WITH CHECK ADD CONSTRAINT [location_order_fk2] FOREIGN KEY ([id_street_to]) REFERENCES [street]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [location_order] CHECK CONSTRAINT [location_order_fk2]
GO

ALTER TABLE [client] WITH CHECK ADD CONSTRAINT [client_fk0] FOREIGN KEY ([id_discount]) REFERENCES [discount]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [client] CHECK CONSTRAINT [client_fk0]
GO

ALTER TABLE [driver] WITH CHECK ADD CONSTRAINT [driver_fk0] FOREIGN KEY ([id_district]) REFERENCES [district]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [driver] CHECK CONSTRAINT [driver_fk0]
GO
ALTER TABLE [driver] WITH CHECK ADD CONSTRAINT [driver_fk1] FOREIGN KEY ([id_car]) REFERENCES [car]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [driver] CHECK CONSTRAINT [driver_fk1]
GO

ALTER TABLE [value_taximeter] WITH CHECK ADD CONSTRAINT [value_taximeter_fk0] FOREIGN KEY ([id]) REFERENCES [order]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [value_taximeter] CHECK CONSTRAINT [value_taximeter_fk0]
GO


ALTER TABLE [order] WITH CHECK ADD CONSTRAINT [order_fk0] FOREIGN KEY ([id_client]) REFERENCES [client]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [order] CHECK CONSTRAINT [order_fk0]
GO
ALTER TABLE [order] WITH CHECK ADD CONSTRAINT [order_fk1] FOREIGN KEY ([id_driver]) REFERENCES [driver]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [order] CHECK CONSTRAINT [order_fk1]
GO
ALTER TABLE [order] WITH CHECK ADD CONSTRAINT [order_fk2] FOREIGN KEY ([id_status]) REFERENCES [status]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [order] CHECK CONSTRAINT [order_fk2]
GO
ALTER TABLE [order] WITH CHECK ADD CONSTRAINT [order_fk3] FOREIGN KEY ([id_application_user]) REFERENCES [application_user]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [order] CHECK CONSTRAINT [order_fk3]
GO


ALTER TABLE [car] WITH CHECK ADD CONSTRAINT [car_fk0] FOREIGN KEY ([id_brand]) REFERENCES [brand]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [car] CHECK CONSTRAINT [car_fk0]
GO
ALTER TABLE [car] WITH CHECK ADD CONSTRAINT [car_fk1] FOREIGN KEY ([id_type]) REFERENCES [type_car]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [car] CHECK CONSTRAINT [car_fk1]
GO




