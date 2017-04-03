create table account (
    user_id char(30) not null primary key,
    password char(100) not null,
    created_at datetime not null
);
create table diary (
    id int not null primary key auto_increment,
    title varchar(50) not null,
    content varchar(4000) not null,
    is_public tinyint not null,
    user_id char(30) not null,
    created_at datetime not null
);