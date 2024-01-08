## 1 JavaEE stack
1. Был загружен GlassFish.

<code>
'asadmin start-domain/stop-domain'
</code>

3. Выбрана бд PostgreSQL - преимущества: опенсорсный проект, горизонтально и вертикально масштабируемый. 
4. Подгружена jdbc на сервер для работы с бд.
5. Предметная область - студенческие общежития, ее структура описана в формате MindMap ![Предметная область]![image](https://github.com/Lilpank/ACS/assets/109220001/2508b3d3-3e1a-43fe-a807-fb11bec0bf6f)
* DDL instance script - https://github.com/Lilpank/ACS/blob/master/src/main/resources/META-INF/sql/init.sql
* DML instance script - https://github.com/Lilpank/ACS/blob/master/src/main/resources/META-INF/sql/metadata.sql 
6. Используемые бины: 
   * Entity Bean - для хранения данных. Entity class: Dormitories, Rooms, Students.
   * Stateless Session Bean - для получения данных из бд. Stateless services class: Dormitories, Rooms, Students.  
7. JSP - для отображения данных

HTTP запросы:
* GET: /main - отображения всех объектов. /university; /students; /rooms; - получение объектов.
* POST: /university; /students; /rooms; - Для создания сущностей.
* Delete: /university; /students; /rooms; - Для удаления сущностей.