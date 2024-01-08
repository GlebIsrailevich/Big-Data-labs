INSERT into dormitories (id, university, id_dorm) VALUES
    (1, 'Samara University', 1);
    
INSERT into rooms (id, id_dorm, id_room) VALUES
    (1, 1, 10),
    (2, 1, 11),
    (3, 1, 12),
    (4, 1, 13),
    (5, 1, 14),
    (6, 1, 101),
    (7, 1, 210),
    (8, 1, 150),
    (9, 1, 521),
    (10, 1, 512),
    (11, 1, 421),
    (12, 1, 101),
    (13, 1, 102);

INSERT into students (id_card, id_dorm, id_room, full_name, sex, avg_score, year_education) VALUES
    (1324, 1, 10, 'Ivanov Ivan Ivanovich', 'M', 4.6, 1),
    (1024, 1, 11, 'Petrov Petr Petrovich', 'M', 3.3, 4),
    (0512, 1, 12, 'Sidorov Sergey Sergeevich', 'M', 4.1, 2),
    (0128, 1, 13, 'Marinyuk Nikolay Nikolaevich','M', 4.7, 1),
    (0064, 1, 14, 'Akhmetbaev Nursultan Abaevich', 'M', 4.2 , 2),
    (0032, 1, 101, 'Saparmuratov Gurbanhuly Kuvvatovich', 'M', 3.9, 4),
    (0016, 1, 210,'Karimov Tamerlan Ravshanovich', 'M', 3.8, 4),
    (0008, 1, 150, 'Aliyev Magomed Suleymanovich', 'M', 4, 1),
    (1356, 1, 521, 'Nikolaeva Irina Aleksandrovna', 'F', 4.4, 1),
    (1470, 1, 512, 'Pavlova Ekaterina Sergeevna', 'F', 5, 3),
    (1487, 1, 421, 'Shevchenko Olesya Vladimirovna', 'F', 4, 4),
    (1489, 1, 101, 'Akhmetova Farida Rustamovna', 'F', 4.1, 1),
    (1517, 1, 102, 'Nikitina Kseniya Aleksandrovna', 'F', 3.8, 2),
    (1523, 1, 101, 'Petrenko Elena Pavlovna', 'F', 4.3, 3),
    (1600, 1, 101, 'Garcia Maria', 'F', 4, 5),
    (1650, 1, 101, 'Adegbie Laura', 'F', 4.2, 2);

