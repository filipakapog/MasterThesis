-- ##########
-- # ADMINS #
-- ##########
INSERT INTO ADMINS (name, password) VALUES ('Filip', 'filip');

-- ###########
-- # DOCTORS #
-- ###########
INSERT INTO DOCTORS (firstName, secondName, lastName, password) VALUES ('Ion',	'George', 	'Popescu', 'popescu');
INSERT INTO DOCTORS (firstName, secondName, lastName, password) VALUES ('Mihai',		  '', 	'Ionescu', 'ionescu');

-- ############
-- # PATIENTS #
-- ############
INSERT INTO PATIENTS (patientId, firstName, secondName, lastName, birthday) VALUES (1,		'George', 	'',   'Becali', 	'1958-06-24');
INSERT INTO PATIENTS (patientId, firstName, secondName, lastName, birthday) VALUES (2,		'Traian', 	'',  'Basescu', 	'1951-11-04');
INSERT INTO PATIENTS (patientId, firstName, secondName, lastName, birthday) VALUES (3,		'Liviu', 	'',  'Dragnea',  	'1962-10-28');
INSERT INTO PATIENTS (patientId, firstName, secondName, lastName, birthday) VALUES (4,		'Klaus', 	'', 'Iohannis', 	'1959-06-13');

-- #############
-- # DIAGNOSIS #
-- #############
INSERT INTO DIAGNOSES (consultDate, result, patientId) VALUES ('2007-07-21',		'SANATOS', 	1);
INSERT INTO DIAGNOSES (consultDate, result, patientId) VALUES ('2010-12-24',  	 'BOLNAV', 	1);
INSERT INTO DIAGNOSES (consultDate, result, patientId) VALUES ('1998-03-02',  'NECUNOSCUT', 	2);
INSERT INTO DIAGNOSES (consultDate, result, patientId) VALUES ('2000-02-01',  'NECUNOSCUT', 	2);
INSERT INTO DIAGNOSES (consultDate, result, patientId) VALUES ('2005-06-12',  	 'BOLNAV', 	3);
INSERT INTO DIAGNOSES (consultDate, result, patientId) VALUES ('2005-06-13',  	 'BOLNAV', 	4);

