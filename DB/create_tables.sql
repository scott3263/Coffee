drop table  `Coffee`;

CREATE TABLE `Coffee` (
  `coffee_id` int not null auto_increment  COMMENT '아이디',
  `name`  varchar(200) not NULL COMMENT '품명',
  `kind`  varchar(100) not NULL COMMENT '중류',
  `price` int not NULL COMMENT '가격',
  `reg_at` datetime  not null DEFAULT current_timestamp() COMMENT '등록일시',
  `mod_at` datetime  null DEFAULT 0 on update current_timestamp() COMMENT '수정일시',
  PRIMARY KEY (`coffee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='커피';

insert into Coffee (name, kind, price, reg_at) values ("아메리카노","커피",1500);
insert into Coffee (name, kind, price, reg_at) values ("에스프레소","커피",1500);
insert into Coffee (name, kind, price, reg_at) values ("라떼","커피",1500);

insert into Coffee (name, kind, price) values ("라떼","커피",1500);

update Coffee set name = '아이스라테' where coffee_id = 3;

CREATE UNIQUE INDEX `prime_num_UNIQUE_02` ON `Coffee` (`hash_value`);
CREATE INDEX `prime_num_idx_01` ON `Coffee` (`int_num`);
CREATE INDEX `prime_num_idx_02` ON `Coffee` (`calc_duration`);
CREATE INDEX `prime_num_idx_03` ON `Coffee` (`reg_date`);

select coffee_id, name, kind, price,
	   date_format(reg_at, '%Y.%m.%d') as reg_at,
       date_format(mod_at, '%Y.%m.%d') as mod_at
 from Coffee ;
 
 select *
 from Coffee ;


