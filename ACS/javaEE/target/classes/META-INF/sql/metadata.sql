insert into dormitories (university, id_dorm) values
(1, 1);

insert into rooms (id_dorm, id_room) values
(1, 1),
(1, 2),
(1, 3);

INSERT into students (ID_card, id_dorm, id_room, full_name, sex, avg_score, year_education) VALUES
    (1324, 1, 1, 'Ivanov Ivan Ivanovich', 'M', 4.6, 1),
    (1024, 1, 2, 'Petrov Petr Petrovich', 'M', 3.3, 4),
    (0512, 1, 3, 'Sidorov Sergey Sergeevich', 'M', 4.1, 2);

--INSERT into students (ID_card, id_room, full_name, sex, avg_score, year_education) VALUES
--    (1324, 1, 'Ivanov Ivan Ivanovich', 'M', 4.6, 1),
--    (1024, 2, 'Petrov Petr Petrovich', 'M', 3.3, 4),
--    (0512, 3, 'Sidorov Sergey Sergeevich', 'M', 4.1, 2),
--    (0128, 4, 'Marinyuk Nikolay Nikolaevich','M', 4.7, 1),
--    (0064, 5, 'Akhmetbaev Nursultan Abaevich', 'M', 4.2 , 2),
--    (0032, 6, 'Saparmuratov Gurbanhuly Kuvvatovich', 'M', 3.9, 4),
--    (0016, 7, 'Karimov Tamerlan Ravshanovich', 'M', 3.8, 4),
--    (0008, 8, 'Aliyev Magomed Suleymanovich', 'M', 4, 1),
--    (1356, 9, 'Nikolaeva Irina Aleksandrovna', 'F', 4.4, 1),
--    (1470, 10, 'Pavlova Ekaterina Sergeevna', 'F', 5, 3),
--    (1487, 11, 'Shevchenko Olesya Vladimirovna', 'F', 4, 4),
--    (1489, 12, 'Akhmetova Farida Rustamovna', 'F', 4.1, 1),
--    (1517, 13, 'Nikitina Kseniya Aleksandrovna', 'F', 3.8, 2),
--    (1523, 14, 'Petrenko Elena Pavlovna', 'F', 4.3, 3),
--    (1600, 15, 'Garcia Maria', 'F', 4, 5),
--    (1650, 16, 'Adegbie Laura', 'F', 4.2, 2);