install.packages('foreign')
install.packages('readxl')

library(foreign)
library(dplyr)
library(ggplot2)
library(readxml)
library('readxl')

raw_df <- read.spss(file = './Lecture/RMD/Koweps_hpc10_2015_beta1.sav', to.data.frame = T)
df <- raw_df

head(df, 3)
str(df)

df <- rename(df, 
  sex=h10_g3, birth=h10_g4, marriage=h10_g10, religion=h10_g11,
  income=p1002_8aq1, code_job=h10_eco9, code_region=h10_reg7
)

# 성별 월급 차이
table(is.na(df$sex))
df$sex <- ifelse(df$sex == 9, NA, df$sex)
df$sex <- ifelse(df$sex == 1, 'male', 'female')

qplot(df$sex)
summary(df$income)
qplot(df$income)
qplot(df$income) + xlim(0, 1000)

table(is.na(df$income))
df$income <-  ifelse(df$income %in% c(0, 9999), NA, df$income)

sex_income <- df %>%
  filter(!is.na(income)) %>%
  group_by(sex) %>%
  summarise(mean_income = mean(income))

sex_income
g1 <- ggplot(data = sex_income, aes(x=sex, y=mean_income))
g2 <- geom_col()
g1 + g2

class(df$birth)
summary(df$birth)
qplot(df$birth)

# 연령대별 월급 차이
table(is.na(df$birth))
df$birth <- ifelse(df$birth == 9999, NA, df$birth)

df$age <- 2015 - df$birth + 1
summary(df$age)

age_income <- df %>%
  filter(!is.na(income)) %>%
  group_by(age) %>%
  summarise(mean_income = mean(income))

age_income
ggplot(data = age_income, aes(x=age, y=mean_income)) + geom_line()

df <- df %>%
  mutate(ageg = ifelse(
    age < 30, 'young',
      ifelse(age <= 59, 'middle', 'old')
    ))

qplot(df$ageg)

ageg_income <- df %>%
  filter(!is.na(income)) %>%
  group_by(ageg) %>%
  summarise(mean_income = mean(income))

ageg_income
ggplot(data = ageg_income, aes(x=ageg, y=mean_income)) + geom_col()

# 연령대 및 성별 월급 차이
ageg_sex_income <- df %>%
  filter(!is.na(income)) %>%
  group_by(ageg, sex) %>%
  summarise(mean_income = mean(income))

ageg_sex_income
ggplot(data = ageg_sex_income, aes(x=ageg, y=mean_income, fill=sex)) + geom_col(position = 'dodge')

age_sex_income <- df %>%
  filter(!is.na(income)) %>%
  group_by(age, sex) %>%
  summarise(mean_income = mean(income))

age_sex_income
ggplot(data = age_sex_income, aes(x=age, y=mean_income, col=sex)) + geom_line()

# 직업별 월급 차이
class(df$code_job)
table(df$code_job)

list_job <- read_excel('./Lecture/RMD/Koweps_Codebook.xlsx', col_names = T, sheet = 2)
head(list_job)

head(df$code_job, 3)
df <- left_join(df, list_job, by='code_job')
head(df, 3)

job_income <- df %>%
  filter(!is.na(code_job) & !is.na(income)) %>%
  group_by(code_job, job) %>%
  summarise(mean_income = mean(income))

top10 <- job_income %>%
  arrange(desc(mean_income)) %>%
  head(10)

top10
g1 <- ggplot(data = top10, aes(x=reorder(job, mean_income), y=mean_income))
g2 <- geom_col()
g3 <-  coord_flip()
g1 + g2 + g3

bottom10 <- job_income %>%
  arrange(mean_income) %>%
  head(10)

bottom10
g1 <- ggplot(data = bottom10, aes(x=reorder(job, mean_income), y=mean_income))
g2 <- geom_col()
g3 <-  coord_flip()
g1 + g2 + g3 + ylim(0, 300)

# 성별 직업 수
job_male <- df %>%
  filter(!is.na(job) & sex == 'male') %>%
  group_by(job) %>%
  summarise(n=n()) %>%
  arrange(desc(n)) %>%
  head(10)

job_female <- df %>%
  filter(!is.na(job) & sex == 'female') %>%
  group_by(job) %>%
  summarise(n=n()) %>%
  arrange(desc(n)) %>%
  head(10)

job_male
job_female

g1 <- ggplot(data = job_male, aes(x=reorder(job, n), y=n))
g2 <- geom_col()
g3 <-  coord_flip()
g1 + g2 + g3

g1 <- ggplot(data = job_female, aes(x=reorder(job, n), y=n))
g2 <- geom_col()
g3 <-  coord_flip()
g1 + g2 + g3

# 종교 유무에 따른 이혼율
table(df$religion)
df$religion <-ifelse(df$religion == 1, 'yes', 'no')

table(df$marriage)

df$group_marriage <- ifelse(df$marriage == 1, 'marriage',
       ifelse(df$marriage == 3, 'divorce', NA))
table(df$group_marriage)
table((is.na(df$group_marriage)))
qplot(df$group_marriage)

df %>%
  filter(!is.na(group_marriage)) %>%
  group_by(religion, group_marriage) %>%
  summarise(n=n()) %>%
  mutate(tot_group=sum(n)) %>%
  mutate(pct=round(n/tot_group*100, 1))

religion_marriage <- df %>%
  filter(!is.na(group_marriage)) %>%
  count(religion, group_marriage) %>%
  group_by(religion) %>%
  mutate(tot_group=sum(n)) %>%
  mutate(pct=round(n/tot_group*100, 1))

divorce <- religion_marriage %>%
  filter(group_marriage == 'divorce') %>%
  select(religion, pct)

divorce
ggplot(data=divorce, aes(x=religion, y = pct)) + geom_col()


ageg_marriage <- df %>%
  filter(!is.na(group_marriage)) %>%
  group_by(ageg, group_marriage) %>%
  summarise(n=n()) %>%
  mutate(tot_group=sum(n)) %>%
  mutate(pct=round(n/tot_group*100, 1))

ageg_marriage

ageg_marriage <- df %>%
  filter(!is.na(group_marriage) & ageg != 'young') %>%
  group_by(ageg, religion, group_marriage) %>%
  summarise(n=n()) %>%
  mutate(tot_group=sum(n)) %>%
  mutate(pct=round(n/tot_group*100, 1))

df_divorce <- ageg_marriage %>%
  filter(group_marriage == 'divorce') %>%
  select(ageg, religion, pct)

df_divorce
ggplot(df_divorce, aes(x=ageg, y=pct, fill=religion)) + geom_col(position = 'dodge')

# 지역별 연령대 비율
table(df$code_region)
list_region <- data.frame(
  code_region = c(1:7),
  region = c('서울', '수도권(인천/경기)', '부산/경남/울산', '대구/경북',
             '대전/충남', '강원/충북', '광주/전남/전북/제주도')
)

df <- left_join(df, list_region, by='code_region')
df %>%
  select(code_region, region) %>%
  tail(10)

region_ageg <- df %>%
  group_by(region, ageg) %>%
  summarise(n=n()) %>%
  mutate(tot_group=sum(n)) %>%
  mutate(pct=round(n/tot_group*100, 2))

head(region_ageg, 3)
ggplot(data = region_ageg, aes(x = region, y = pct, fill = ageg)) + geom_col() + coord_flip()
