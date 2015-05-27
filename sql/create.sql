create table t_user(
	id bigint identity primary key,
	user_name varchar(60),
	password varchar(60),
	birthday datetime,
	height int,
	balance decimal(19,6)
)