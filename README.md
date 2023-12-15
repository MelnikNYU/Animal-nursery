# Информация о проекте
_________
Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.

## Как сдавать проект
_________
Для сдачи проекта необходимо создать отдельный общедоступный
репозиторий(Github, gitlub, или Bitbucket). Разработку вести в этом
репозитории, использовать пул реквесты на изменения. Программа должна
запускаться и работать, ошибок при выполнении программы быть не должно.
Программа, может использоваться в различных системах, поэтому необходимо
разработать класс в виде конструктора

## Задание
_________
1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).

- mn@hp-gb:~$ mkdir Animals
- mn@hp-gb:~$ cd ~/Animals
- mn@hp-gb:~/Animals$ cat > pets
- mn@hp-gb:~/Animals$ cat > pack_animals
- mn@hp-gb:~/Animals$ cat pets pack_animals > animals
- mn@hp-gb:~/Animals$ mv animals mans_friends
- mn@hp-gb:~/Animals$ ls -ali

![](https://github.com/MelnikNYU/Animal-nursery/blob/main/1.png) 

2. Создать директорию, переместить файл туда.
- mn@hp-gb:~/Animals$ cd ..
- mn@hp-gb:~$ mkdir Animalss
- mn@hp-gb:~$ cd ~/Animals
- mn@hp-gb:~/Animals$ mv mans_friends ~/Animalss
- mn@hp-gb:~/Animals$ cd ~/Animalss
- mn@hp-gb:~/Animalss$ ls -ali
- итого 12
- 581637 drwxrwxr-x  2 mn mn 4096 дек 15 22:24 .
- 528864 drwxr-x--- 24 mn mn 4096 дек 15 22:21 ..
- 529265 -rw-rw-r--  1 mn mn   76 дек 15 22:01 mans_friends
- mn@hp-gb:~/Animalss$
3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.
![](https://github.com/MelnikNYU/Animal-nursery/blob/main/2.png)
4. Установить и удалить deb-пакет с помощью dpkg.
![](https://github.com/MelnikNYU/Animal-nursery/blob/main/3.png)
![](https://github.com/MelnikNYU/Animal-nursery/blob/main/4.png)
5. Выложить историю команд в терминале ubuntu
![](https://github.com/MelnikNYU/Animal-nursery/blob/main/5.png)
6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы).
![](https://github.com/MelnikNYU/Animal-nursery/blob/main/6.png)
7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”

'CREATE DATABASE Human_friends;'

8. Создать таблицы с иерархией из диаграммы в БД

'USE Human_friends;
CREATE TABLE animals_classes
(
	Id INT AUTO_INCREMENT PRIMARY KEY, 
	Class_name VARCHAR(45)
);

INSERT INTO animals_classes (Class_name)
VALUES ('pets'),
('pack_animals');  


CREATE TABLE pets
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR (45),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animals_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pets (Name, Class_id)
VALUES ('Dogs', 1),
('Cats', 1),  
('Hamsters', 1);

CREATE TABLE pack_animals
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR (45),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animals_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pack_animals (Name, Class_id)
VALUES ('Horses', 2),
('Camels', 2),  
('Donckeys', 2);' 

9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения

'CREATE TABLE dogs 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(45), 
    Birthday DATE,
    Commands VARCHAR(100),
    Animal_id int,
    Foreign KEY (Animal_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO dogs (Name, Birthday, Commands, Animal_id)
VALUES ('Лайка', '2018-03-12', 'сидеть, лежать, голос', 1),
('Белка', '2019-07-22', "прыгать, спать, стоп, голос", 1), 
('Стрелка', '2023-01-21', "ко мне, рядом, сидеть, стоп, голос", 1);

CREATE TABLE cats 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(45), 
    Birthday DATE,
    Commands VARCHAR(100),
    Animal_id int,
    Foreign KEY (Animal_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO cats (Name, Birthday, Commands, Animal_id)
VALUES ('Мурка', '2022-04-05', 'кушать', 'брысь', 2),
('Пушистик', '2015-07-13', 'играть', 'кушать', 2),  
('Усик', '2016-11-11', 'кушать', 'брысь', 2); 

CREATE TABLE hamsters 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(45), 
    Birthday DATE,
    Commands VARCHAR(100),
    Animal_id int,
    Foreign KEY (Animal_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO hamsters (Name, Birthday, Commands, Animal_id)
VALUES ('Изя', '2022-12-22', 'Еда', 3),
('Кусь', '2020-08-10', "Фу", 3), 
('Гусь', '2021-06-16', "Фу", 3);

CREATE TABLE horses 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(45), 
    Birthday DATE,
    Commands VARCHAR(100),
    Animal_id int,
    Foreign KEY (Animal_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO horses (Name, Birthday, Commands, Animal_id)
VALUES ('Буря', '2017-07-15', 'вперед', 'быстрее', 'стоп', 1),
('Снег', '2015-05-18', 'вперед', 'быстрее', 'стоп', 1),  
('Огонь', '2021-07-17', 'вперед', 'быстрее', 'стоп', 1);

CREATE TABLE camels 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(45), 
    Birthday DATE,
    Commands VARCHAR(100),
    Animal_id int,
    Foreign KEY (Animal_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO camels (Name, Birthday, Commands, Animal_id)
VALUES ('Уля', '2020-06-17', 'вперед', 'быстрее', 'стоп', 2),
('Скала', '2016-12-12', 'вперед', 'быстрее', 'стоп', 2), 
('Гор', '2020-10-20', 'вперед', 'быстрее', 'стоп', 2);

CREATE TABLE donkeys 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(45), 
    Birthday DATE,
    Commands VARCHAR(100),
    Animal_id int,
    Foreign KEY (Animal_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO donkeys (Name, Birthday, Commands, Animal_id)
VALUES ('Осел', '2017-05-30', 'вперед', 'быстрее', 'стоп', 3),
('Ишак', '2013-09-21', 'вперед', 'быстрее', 'стоп', 3),   
('Урик', '2027-11-05', 'вперед', 'быстрее', 'стоп', 3);'


10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

'SET SQL_SAFE_UPDATES = 0;
DELETE FROM camels;

SELECT Name, Birthday, Commands FROM horses
UNION SELECT  Name, Birthday, Commands FROM donkeys;'

11.Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице

CREATE TEMPORARY TABLE animals AS 
SELECT *, 'Horses' as animal FROM horses
UNION SELECT *, 'Donckeys' AS animal FROM donkeys
UNION SELECT *, 'Dogs' AS animal FROM dogs
UNION SELECT *, 'Cats' AS animal FROM cats
UNION SELECT *, 'Hamsters' AS animal FROM hamsters;

CREATE TABLE yang_animal AS
SELECT Name, Birthday, Commands, animal, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age_in_month
FROM animals WHERE Birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);
 
SELECT * FROM yang_animal;

12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.

SELECT d.Name, d.Birthday, d.Commands, do.Name, ya.Age_in_month 
FROM dogs d
LEFT JOIN yang_animal ya ON ya.Name = do.Name
LEFT JOIN pets do ON d.Id = d.Animal_id
UNION
SELECT c.Name, c.Birthday, c.Commands, ca.Name, ya.Age_in_month 
FROM cats c
LEFT JOIN yang_animal ya ON ya.Name = c.Name
LEFT JOIN pets do ON do.Id = c.Animal_id
UNION
SELECT hm.Name, hm.Birthday, hm.Commands, do.Name, ya.Age_in_month 
FROM hamsters hm
LEFT JOIN yang_animal ya ON ya.Name = hm.Name
LEFT JOIN pets do ON do.Id = hm.Animal_id;
UNION
SELECT h.Name, h.Birthday, h.Commands, pa.Name, ya.Age_in_month 
FROM horses h
LEFT JOIN yang_animal ya ON ya.Name = h.Name
LEFT JOIN pack_animals pa ON pa.Id = h.Animal_id
UNION 
SELECT d.Name, d.Birthday, d.Commands, pa.Name, ya.Age_in_month 
FROM donkeys d 
LEFT JOIN yang_animal ya ON ya.Name = d.Name
LEFT JOIN pack_animals pa ON pa.Id = d.Animal_id'

13.Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
14. Написать программу, имитирующую работу реестра домашних животных.
В программе должен быть реализован следующий функционал:
14.1 Завести новое животное
14.2 определять животное в правильный класс
14.3 увидеть список команд, которое выполняет животное
14.4 обучить животное новым командам
14.5 Реализовать навигацию по меню
15.Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
значение внутренней̆int переменной̆на 1 при нажатие “Завести новое
животное” Сделайте так, чтобы с объектом такого типа можно было работать в
блоке try-with-resources. Нужно бросить исключение, если работа с объектом
типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
считать в ресурсе try, если при заведения животного заполнены все поля.