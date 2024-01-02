# 데이터 가공
library(dplyr)
library(ggplot2)

exam <- read.csv('./Lecture/RMD/csv_exam.csv')
exam

exam %>%
  filter(class == 1)

exam %>%
  filter(class == 2)

exam %>% 
  filter(class != 1)

exam %>%
  filter(class != 3)

exam %>% 
  filter(math > 50)

exam %>%
  filter(math < 50)

exam %>%
  filter(english >= 80)

exam %>%
  filter(english <= 80)

exam %>%
  filter(class == 1 & math >= 50)

exam %>%
  filter(class == 2 & english >= 80)

exam %>% 
  filter(math >= 90 | english >= 90)

exam %>%
  filter(english < 90 | science < 50)

exam %>%
  filter(class == 1 | class == 3 | class == 5)

exam %>%
  filter(class %in% c(1, 3, 5)) # %in% - SQL의 in과 같은 기능

class1 <- exam %>%
  filter(class == 1)
mean(class1$math) # 46.25

class2 <- exam %>%
  filter(class == 2)
mean(class2$math) # 61.25

# %/% - 몫, %% - 나머지

# mpg 데이터 다루기
mpg

mpg_df <- as.data.frame(mpg)
mpg_df

# 1번 문제
displ4 <- mpg_df %>% 
  filter(displ <= 4)
mean(displ4$hwy) # 25.96319

displ5 <- mpg_df %>% 
  filter(displ >= 5)
mean(displ5$hwy) # 18.07895

# 2번 문제
audi <- mpg_df %>%
  filter(manufacturer == 'audi')
mean(audi$cty) # 17.61111

toyota <- mpg_df %>%
  filter(manufacturer == 'toyota')
mean(toyota$cty) # 18.52941

# 3번 문제
cars <- mpg_df %>%
  filter(manufacturer %in% c('chevrolet', 'ford', 'honda'))
mean(cars$hwy) # 22.50943


exam %>% 
  select(math)

exam %>%
  select(english)

exam %>%
  select(class, math, english)

exam %>%
  select(-math)

exam %>%
  select(-math, -english)

exam %>%
  filter(class == 1) %>%
  select(english)

exam %>%
  select(id, math) %>%
  head # 앞 6행

exam %>%
  select(id, math) %>%
  head(10) # 앞 10행

# 1번 문제
class_cty <- mpg_df %>%
  select(class, cty)
class_cty

# 2번 문제
suv <- class_cty %>%
  filter(class == 'suv')
mean(suv$cty) # 13.5

compact <- class_cty %>%
  filter(class == 'compact')
mean(compact$cty) # 20.12766


exam %>%
  arrange(math) # math 오름차순

exam %>%
  arrange(desc(math)) # math 내림차순

exam %>%
  arrange(class, math)

mpg_df %>%
  filter(manufacturer == 'audi') %>%
  arrange(desc(hwy)) %>%
  head(5)


exam %>%
  mutate(total = math + english + science) %>% # 합계(파생변수) 추가
  head

exam %>%
  mutate(total = math + english + science,
         mean = (math + english + science) / 3) %>%
  head

exam %>%
  mutate(test = ifelse(science >= 60, 'pass', 'fail')) %>%
  head

exam %>%
  mutate(total = math + english + science) %>%
  arrange(total) %>%
  head

# 1번 문제
df <- mpg_df
df <- df %>%
  mutate(totmil = cty + hwy)
df

# 2번 문제
df <- df %>%
  mutate(avgmil = totmil / 2)
df

# 3번 문제
df %>%
  arrange(desc(avgmil)) %>%
  head(3)

# 4번 문제
mpg_df %>%
  mutate(total = cty + hwy, mean = total / 2) %>%
  arrange(desc(mean)) %>%
  head(3)


test1 <- data.frame(id = c(1, 2, 3, 4, 5),
                    midterm = c(60, 70, 80, 90, 85))

test2 <- data.frame(id = c(1, 2, 3, 4, 5),
                    final = c(70, 83, 65, 95, 80))

test1
test2

total <- left_join(test1, test2, by = 'id')
total

name <- data.frame(class = c(1, 2, 3, 4, 5),
                   teacher = c('kim', 'lee', 'park', 'choi', 'jung'))
name

exam_new <- left_join(exam, name, by ="class")
exam_new

group_a <- data.frame(id = c(1, 2, 3, 4, 5),
                      test = c(60, 70, 80, 90, 85))
group_b <- data.frame(id = c(6, 7, 8, 9, 10),
                      test = c(70, 83, 65, 95, 80))
group_a
group_b

group_all <- bind_rows(group_a, group_b)
group_all

# mpg 데이터 다루기
mpg_df <- as.data.frame(mpg)
fuel <- data.frame(fl = c('c', 'd', 'e', 'p', 'r'),
                   price_fl = c(2.35, 2.38, 2.11, 2.76, 2.22),
                   stringsAsFactors = F)
fuel

# 1번 문제
mpg_df <- left_join(mpg_df, fuel, by = "fl")
mpg_df

# 2번 문제
mpg_df %>%
  select('model', 'fl', 'price_fl') %>%
  head(5)


# 분석 도전
midwest <- as.data.frame(midwest)

# 1번
midwest <- midwest %>%
  mutate(ratio_child = (midwest$poptotal - midwest$popadults) / midwest$poptotal)
midwest$ratio_child

# 2번
midwest %>%
  arrange(desc(ratio_child)) %>%
  select(county, ratio_child) %>%
  head(5)

# 3번
midwest <- midwest %>%
  mutate(grade_child = ifelse(ratio_child >= 0.4, 'large',
                              ifelse(ratio_child >= 0.3, 'middle', 'small')))
table(midwest$grade_child)

# 4번
midwest <- midwest %>%
  mutate(ratio_asian = (df$poptotal - df$popasian) / df$poptotal)

midwest %>%
  arrange(desc(ratio_asian)) %>%
  select(state, county, ratio_asian) %>%
  tail(10)



# 데이터 정제
df <- data.frame(sex = c('M', 'F', NA, 'M', 'F'),
                 score = c(5, 4, 3, 4, NA))
df

is.na(df)
table(is.na(df))

table(is.na(df$sex))
table(is.na(df$score))

mean(df$score) # NA
sum(df$score) # NA

df %>% filter(is.na(score)) # 결측치 출력
df %>% filter(!is.na(score))

df_nomiss <- df %>% filter(!is.na(score))
mean(df_nomiss$score) # 4
sum(df_nomiss$score) # 16

df_nomiss <- df %>% filter(!is.na(score) & !is.na(sex))
df_nomiss

df_nomiss2 <- na.omit(df)
df_nomiss2

mean(df$score, na.rm = T) # 4
sum(df$score, na.rm = T) # 16

exam <- read.csv('./Lecture/RMD/csv_exam.csv')
exam[c(3, 8, 15), 'math'] <- NA

exam %>% summarise(mean_math = mean(math)) # NA
exam %>% summarise(mean_math = mean(math, na.rm = T)) # 55.23529

exam %>% summarise(mean_math = mean(math, na.rm = T),
                   sum_math = sum(math, na.rm = T),
                   median_math = median(math, na.rm = T))

mean(exam$math, na.rm = T) # 55.23529
exam$math <- ifelse(is.na(exam$math), 55, exam$math)
table(is.na(exam$math))
exam
mean(exam$math) # 55.2

# mpg 결측치 처리
mpg <- as.data.frame(ggplot2::mpg)
mpg[c(65, 124, 131, 153, 212), 'hwy'] <- NA

# 1번 문제
table(is.na(mpg$drv)) # 0
table(is.na(mpg$hwy)) # 5

# 2번 문제
mpg %>%
  filter(!is.na(hwy)) %>%
  group_by(drv) %>%
  summarise(hwy_mean = mean(hwy))


outlier <- data.frame(sex = c(1, 2, 1, 3, 2, 1),
                      score = c(5, 4, 3, 4, 2, 6))
outlier

table(outlier$sex)
table(outlier$score)

outlier$sex <- ifelse(outlier$sex == 3, NA, outlier$sex)
outlier

outlier$score <- ifelse(outlier$score > 5, NA, outlier$score)
outlier

outlier %>%
  filter(!is.na(sex) & !is.na(score)) %>%
  group_by(sex) %>%
  summarise(mean_score = mean(score))

mpg <- as.data.frame(ggplot2::mpg)
boxplot(mpg$hwy)
boxplot(mpg$hwy)$stats # 12 ~ 37

mpg$hwy <- ifelse(mpg$hwy < 12 | mpg$hwy > 37, NA, mpg$hwy)
table(is.na(mpg$hwy))

mpg %>%
  group_by(drv) %>%
  summarise(mean_hwy = mean(hwy, na.rm = T))

# mpg 이상치 처리
mpg <- as.data.frame(ggplot2::mpg)
mpg[c(10, 14, 58, 93), 'drv'] <- 'k'
mpg[c(29, 43, 129, 203), 'cty'] <- c(3, 4, 39, 42)

# 1번 문제
table(mpg$drv)
mpg$drv <- ifelse(mpg$drv %in% 'k', NA, mpg$drv)

# 2번 문제
boxplot(mpg$cty)
boxplot(mpg$cty)$stats
mpg$cty <- ifelse(mpg$cty < 9 | mpg$cty > 26, NA, mpg$cty)

# 3번 문제
mpg %>%
  filter(!is.na(drv)) %>%
  group_by(drv) %>%
  summarise(mean_cty = mean(cty, na.rm = T))
