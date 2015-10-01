
insert into room(description,size) values ('Floor 1 4B','30');
insert into room(description,size) values ('Floor 2 1A','45');
insert into room(description,size) values ('Floor 3 2C','100');

insert into meeting(fk_room,time_from,time_to) values ('1','2015-6-6 00:00:00','2015-6-6 12:00:00'); 

insert into attendee(first_name,last_name,fk_meeting) values ('Juan','Gonzales','1');
insert into attendee(first_name,last_name,fk_meeting) values ('Lucas','Gonzales','1');
insert into attendee(first_name,last_name,fk_meeting) values ('Pedro','Gutierres','1');
insert into attendee(first_name,last_name,fk_meeting) values ('Sebastian','Lopez','1');

