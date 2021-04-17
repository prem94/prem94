
CREATE TABLE TICKET (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  ticket_type  VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  title VARCHAR(250) NOT NULL,
  created_by_user VARCHAR(250) NOT NULL,
  customer VARCHAR(250) NOT NULL,
  assigned_to_agent VARCHAR(250) NOT NULL,
  priority VARCHAR(250) NOT NULL,
  status VARCHAR(250) NOT NULL,
  updated_date date DEFAULT CURRENT_DATE()
);