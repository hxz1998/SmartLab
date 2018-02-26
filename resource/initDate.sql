-- 用户数据
INSERT INTO smartlab.user (id, name, username, password, contact, status, user_start, user_leave) VALUES ('402881e961cd650e0161cd6558830000', '张三', 'zhangsan', '123', '23', 'ADMINISTRATOR', '2018-02-25 22:37:07', null);
INSERT INTO smartlab.user (id, name, username, password, contact, status, user_start, user_leave) VALUES ('402881e961cd650e0161cd6558a70001', '马六', 'maliu', '123', '47823974912', 'USER', '2018-02-25 22:37:07', null);
INSERT INTO smartlab.user (id, name, username, password, contact, status, user_start, user_leave) VALUES ('402881e961cd668c0161cd668ee20000', 'lisi', 'lisi', '123', '23', 'ADMINISTRATOR', '2018-02-25 22:38:26', null);
INSERT INTO smartlab.user (id, name, username, password, contact, status, user_start, user_leave) VALUES ('402881e961cd668c0161cd668eef0001', '小明', 'xiaoming', '123', '47823974912', 'USER', '2018-02-25 22:38:26', null);

-- 新闻数据
INSERT INTO smartlab.news (id, content, title, create_date, user_id) VALUES ('402881e961cd650e0161cd655ef70005', '这是一个新闻，关于最新项目进展的新闻', '项目进展新闻', '2018-02-25 22:37:08', '402881e961cd650e0161cd6558a70001');
INSERT INTO smartlab.news (id, content, title, create_date, user_id) VALUES ('402881e961cd668c0161cd6691f50005', '这是一个新闻，关于最新项目进展的新闻', '项目进展新闻', '2018-02-25 22:38:27', '402881e961cd668c0161cd668eef0001');

-- 比赛数据
INSERT INTO smartlab.contest (id, info, content) VALUES ('402881e961cd650e0161cd655a5f0002', '这是一个比赛', '这是一个比赛，关于SmartLab的开发大赛');
INSERT INTO smartlab.contest (id, info, content) VALUES ('402881e961cd668c0161cd66900e0002', '这是一个比赛', '这是一个比赛，关于SmartLab的开发大赛');

-- 报告数据
INSERT INTO smartlab.report (id, title, content, create_date, user_id) VALUES ('402881e961cd650e0161cd655ef80006', '年度报告', '这是一个报告，年度报告', '2018-02-25 22:37:08', '402881e961cd650e0161cd6558a70001');
INSERT INTO smartlab.report (id, title, content, create_date, user_id) VALUES ('402881e961cd668c0161cd6691f50006', '年度报告', '这是一个报告，年度报告', '2018-02-25 22:38:27', '402881e961cd668c0161cd668eef0001');

-- 文档数据
INSERT INTO smartlab.document (id, info, content, create_date, user_id) VALUES ('402881e961cd650e0161cd655ef90008', '文档', '这是一个文档', '2018-02-25 22:37:08', '402881e961cd650e0161cd6558830000');
INSERT INTO smartlab.document (id, info, content, create_date, user_id) VALUES ('402881e961cd668c0161cd6691f60008', '文档', '这是一个文档', '2018-02-25 22:38:27', '402881e961cd650e0161cd6558830000');

-- 荣誉数据
INSERT INTO smartlab.honor (id, info, content, create_date) VALUES ('402881e961cd650e0161cd655ef80007', '这是荣誉', '这是一个荣誉，全部人的荣誉', '2018-02-25 22:37:08');
INSERT INTO smartlab.honor (id, info, content, create_date) VALUES ('402881e961cd668c0161cd6691f60007', '这是荣誉', '这是一个荣誉，全部人的荣誉', '2018-02-25 22:38:27');

-- 项目数据
INSERT INTO smartlab.project (id, info, create_date, content, pmUser_id, project_progress) VALUES ('402881e961cd650e0161cd655b560003', '这是一个项目', '2018-02-25 22:37:07', '这是一个项目，开发实验室综合管理平台的项目', '402881e961cd650e0161cd6558830000', 20);
INSERT INTO smartlab.project (id, info, create_date, content, pmUser_id, project_progress) VALUES ('402881e961cd650e0161cd655b570004', '这是一个新项目', '2018-02-25 22:37:07', '这是一个新项目，开发实验室综合管理平台的项目的扩展', '402881e961cd650e0161cd6558830000', 20);
INSERT INTO smartlab.project (id, info, create_date, content, pmUser_id, project_progress) VALUES ('402881e961cd668c0161cd6690ac0003', '这是一个项目', '2018-02-25 22:38:26', '这是一个项目，开发实验室综合管理平台的项目', '402881e961cd650e0161cd6558830000', 20);
INSERT INTO smartlab.project (id, info, create_date, content, pmUser_id, project_progress) VALUES ('402881e961cd668c0161cd6690ae0004', '这是一个新项目', '2018-02-25 22:38:26', '这是一个新项目，开发实验室综合管理平台的项目的扩展', '402881e961cd650e0161cd6558830000', 20);

-- 项目时间线数据
INSERT INTO smartlab.project_timeline (id, create_date, info, content, project_id) VALUES (1, '2018-02-25 22:37:08', 'begin', '开始了工程，就不要轻易停下来', '402881e961cd650e0161cd655b560003');
INSERT INTO smartlab.project_timeline (id, create_date, info, content, project_id) VALUES (2, '2018-02-25 22:37:08', 'begin', '开始了工程，就不要轻易停下来', '402881e961cd650e0161cd655b570004');
INSERT INTO smartlab.project_timeline (id, create_date, info, content, project_id) VALUES (3, '2018-02-25 22:37:08', 'end', '工程结束，下次再会', '402881e961cd650e0161cd655b560003');
INSERT INTO smartlab.project_timeline (id, create_date, info, content, project_id) VALUES (4, '2018-02-25 22:37:08', 'end', '工程结束，下次再会', '402881e961cd650e0161cd655b570004');
INSERT INTO smartlab.project_timeline (id, create_date, info, content, project_id) VALUES (5, '2018-02-25 22:38:27', 'begin', '开始了工程，就不要轻易停下来', '402881e961cd668c0161cd6690ac0003');
INSERT INTO smartlab.project_timeline (id, create_date, info, content, project_id) VALUES (6, '2018-02-25 22:38:27', 'begin', '开始了工程，就不要轻易停下来', '402881e961cd668c0161cd6690ae0004');
INSERT INTO smartlab.project_timeline (id, create_date, info, content, project_id) VALUES (7, '2018-02-25 22:38:27', 'end', '工程结束，下次再会', '402881e961cd668c0161cd6690ac0003');
INSERT INTO smartlab.project_timeline (id, create_date, info, content, project_id) VALUES (8, '2018-02-25 22:38:27', 'end', '工程结束，下次再会', '402881e961cd668c0161cd6690ae0004');

-- 用户拥有项目数据
INSERT INTO smartlab.user_has_project (project_id, user_id) VALUES ('402881e961cd650e0161cd655b560003', '402881e961cd650e0161cd6558830000');
INSERT INTO smartlab.user_has_project (project_id, user_id) VALUES ('402881e961cd650e0161cd655b570004', '402881e961cd650e0161cd6558830000');
INSERT INTO smartlab.user_has_project (project_id, user_id) VALUES ('402881e961cd668c0161cd6690ac0003', '402881e961cd650e0161cd6558830000');
INSERT INTO smartlab.user_has_project (project_id, user_id) VALUES ('402881e961cd668c0161cd6690ae0004', '402881e961cd650e0161cd6558830000');
INSERT INTO smartlab.user_has_project (project_id, user_id) VALUES ('402881e961cd650e0161cd655b560003', '402881e961cd650e0161cd6558a70001');
INSERT INTO smartlab.user_has_project (project_id, user_id) VALUES ('402881e961cd650e0161cd655b570004', '402881e961cd650e0161cd6558a70001');
INSERT INTO smartlab.user_has_project (project_id, user_id) VALUES ('402881e961cd668c0161cd6690ac0003', '402881e961cd668c0161cd668ee20000');
INSERT INTO smartlab.user_has_project (project_id, user_id) VALUES ('402881e961cd668c0161cd6690ae0004', '402881e961cd668c0161cd668ee20000');
INSERT INTO smartlab.user_has_project (project_id, user_id) VALUES ('402881e961cd668c0161cd6690ac0003', '402881e961cd668c0161cd668eef0001');
INSERT INTO smartlab.user_has_project (project_id, user_id) VALUES ('402881e961cd668c0161cd6690ae0004', '402881e961cd668c0161cd668eef0001');

-- 项目及成员任务数据
INSERT INTO smartlab.project_member_duty (id, duty_describe, user_id, project_id) VALUES (1, '项目经理', '402881e961cd650e0161cd6558830000', '402881e961cd650e0161cd655b560003');
INSERT INTO smartlab.project_member_duty (id, duty_describe, user_id, project_id) VALUES (2, '开发', '402881e961cd650e0161cd6558a70001', '402881e961cd650e0161cd655b560003');
INSERT INTO smartlab.project_member_duty (id, duty_describe, user_id, project_id) VALUES (3, '项目经理', '402881e961cd650e0161cd6558830000', '402881e961cd668c0161cd6690ac0003');
INSERT INTO smartlab.project_member_duty (id, duty_describe, user_id, project_id) VALUES (4, '开发', '402881e961cd668c0161cd668eef0001', '402881e961cd668c0161cd6690ac0003');

-- 用户拥有比赛数据
INSERT INTO smartlab.user_has_contest (user_id, contest_id) VALUES ('402881e961cd650e0161cd6558830000', '402881e961cd650e0161cd655a5f0002');
INSERT INTO smartlab.user_has_contest (user_id, contest_id) VALUES ('402881e961cd650e0161cd6558a70001', '402881e961cd650e0161cd655a5f0002');
INSERT INTO smartlab.user_has_contest (user_id, contest_id) VALUES ('402881e961cd650e0161cd6558830000', '402881e961cd668c0161cd66900e0002');
INSERT INTO smartlab.user_has_contest (user_id, contest_id) VALUES ('402881e961cd668c0161cd668ee20000', '402881e961cd668c0161cd66900e0002');
INSERT INTO smartlab.user_has_contest (user_id, contest_id) VALUES ('402881e961cd668c0161cd668eef0001', '402881e961cd668c0161cd66900e0002');

-- 用户拥有荣誉数据
INSERT INTO smartlab.user_has_honor (honor_id, user_id) VALUES ('402881e961cd650e0161cd655ef80007', '402881e961cd650e0161cd6558830000');
INSERT INTO smartlab.user_has_honor (honor_id, user_id) VALUES ('402881e961cd668c0161cd6691f60007', '402881e961cd650e0161cd6558830000');
INSERT INTO smartlab.user_has_honor (honor_id, user_id) VALUES ('402881e961cd650e0161cd655ef80007', '402881e961cd650e0161cd6558a70001');
INSERT INTO smartlab.user_has_honor (honor_id, user_id) VALUES ('402881e961cd668c0161cd6691f60007', '402881e961cd668c0161cd668ee20000');
INSERT INTO smartlab.user_has_honor (honor_id, user_id) VALUES ('402881e961cd668c0161cd6691f60007', '402881e961cd668c0161cd668eef0001');