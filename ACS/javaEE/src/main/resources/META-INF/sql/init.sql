DROP  TABLE IF EXISTS dormitories CASCADE;
DROP  TABLE IF EXISTS rooms CASCADE;
DROP  TABLE IF EXISTS students CASCADE;

create table dormitories (
 university text not null,
 id_dorm integer primary key
);

create table rooms(
 id_dorm int references dormitories(id_dorm),
 id_room int primary key
);

create table students(
 id_dorm int references dormitories(id_dorm),
 id_card int primary key,
 id_room int references rooms(id_room),
 full_name text not null,
 sex text check(sex = 'F' or sex ='M'),
 avg_score double,
 year_education int
);