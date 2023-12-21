exam <- read.csv('./Lecture/RMD/csv_exam.csv')
exam

exam[1] # 열(DF 단위)
exam[1, ] # 행
exam[,1] # 열

1+1
2+2
3+3

exam$math
exam[,3]
exam[3]
exam[, 'math']
exam['math']

exam$class == 1

exam[exam$class == 1,] # 클래스가 1인 모든 열
exam[exam$math >= 80,] # 수학 점수가 80 이상인 모든 열
exam[exam$class == 1 & exam $ math >= 50,] # 클래스가 1이고 수학 점수가 50 이상인 모든 열
exam[exam$english < 90 | exam$science < 50, ] # 영어 점수가 90점 이상 이거나 과학 점수가 50점 이상

exam[, 'class']
exam['class']

exam[c('class', 'math')]

exam[exam$math >= 50, c('english', 'science')]

# 수학점수 50 이상, 영어점수 80이상 학생들의 전과목 총평균
exam$tot <- (exam$math + exam$english + exam$science) / 3
aggregate(data=exam[exam$math >= 50 & exam$english >= 80,], tot~class, mean)

install.packages('dplyr')
library(dplyr)

exam %>%
  filter(math >= 50 & english >= 80) %>%
  mutate(tot = (math + english + science) / 3) %>%
  group_by(class) %>%
  summarise(mean = mean(tot))

exam

# mpg 데이터
library(ggplot2)
mpg <- as.data.frame(ggplot2::mpg)
head(mpg)

mpg_mean <- mpg %>%
  mutate(tot = (cty + hwy) / 2) %>%
  filter(class == 'compact' | class == 'suv') %>%
  group_by(class) %>%
  summarise(mean_tot = mean(tot))

mpg_mean


mpg_t <- mpg
mpg_t$tot <- (mpg_t$cty + mpg_t$hwy) / 2
df_comp <- mpg_t[mpg_t$class == 'compact',]
df_suv <- mpg_t[mpg_t$class == 'suv',]

mean(df_comp$tot) # 24.21277
mean(df_suv$tot) # 15.81452

var1 <- c(1, 2, 3, 4, 5)
var1

var1 + 2 # 3 4 5 6 7

var2 <- factor(var1) # Levels: 1 2 3 4 5
var2 # 연산 불가능

levels(var1) # NULL
levels(var2) # "1" "2" "3" "4" "5"

var3 <- c('a', 'b', 'c', 'd', 'e')
var4 <- factor(var3)

class(var3) # "character"

mean(var1) # 3
mean(as.numeric(var2)) # 3

class(mpg$drv) # "character"
mpg$drv <- as.factor(mpg$drv)
levels(mpg$drv) # "4" "f" "r"

mpg$cty
(1:12)

a <- 1
x1 <- data.frame(var1=c(1, 2, 3), var2=c('a', 'b', 'c'))
x2 <- matrix(c(1:12), ncol = 2)
x3 <- array(1:20, dim=c(2, 5, 2))

x4 <- list(f1 = a, # 벡터
           f2 = x1, # 데이터 프레임
           f3 = x2, # 매트릭스
           f4 = x3) # 어레이
x4

x4[2]
x4[[2]]
x4[[2]][['var1']]

x <- boxplot(mpg$cty)
x$stats


seq(1, 10, by=2) # 1 3 5 7 9
v <- seq(1, 5)
mean(v) # 3
max(v) # 5
min(v) # 1
median(v) # 3

str5 = c('hello', 'world', 'is', 'good')
paste(str5, collapse = ' ')

x <- c('a', 'a', 'b', 'c')
qplot(x)


mpg <- ggplot2::mpg
head(mpg, 1)
qplot(data=mpg, x=hwy)
qplot(data=mpg, x=drv, y=hwy)
qplot(data=mpg, x=drv, y=hwy, geom='line')
qplot(data=mpg, x=drv, y=hwy, geom='boxplot', colour=drv)

point <- c(80, 60, 70, 50, 90)
avg <- mean(point) # 70

eng <- c(90, 80, 60, 70)
math <- c(50, 60, 100, 30)
df <- data.frame(eng, math)
df

제품 <- c('사과', '딸기', '수박')
가격 <- c(1800, 1500, 3000)
판매량 <- c(24, 38, 13)
df <- data.frame(제품, 가격, 판매량)
mean(가격)
mean(판매량)

install.packages('readxl')
library(readxl)

df <- read_excel('./Lecture//RMD//excel_exam.xlsx')
head(df, 3)

df <- read_excel('./Lecture//RMD//excel_exam_novar.xlsx', col_names = F)
head(df, 3)

read.csv('./Lecture/RMD/csv_exam.csv')
read.csv('./Lecture/RMD/csv_exam_str.csv', stringsAsFactors = T) # 팩터 호환
read.csv('./Lecture/RMD/csv_exam_str.csv', stringsAsFactors = F)

df <- read.csv('./Lecture/RMD/csv_exam_str.csv', stringsAsFactors = T)
write.csv(df, file = 'my_exam.csv')

df <- read.csv('./Lecture/RMD/csv_exam.csv')
head(df, 5)
tail(df, 5)
dim(df) # 20  5
str(df)
summary(df)

mpg <- as.data.frame(ggplot2::mpg)
head(mpg, 3)
dim(mpg) # 234  11
str(mpg)

df_raw <- data.frame(var1 = c(1, 2, 1), var2 = c(2, 3, 2))
df_raw

df <- df_raw
df <- rename(df, v2= var2)
df

mpg_copy <- mpg
mpg_copy

mpg_copy <- rename(mpg_copy, city=cty, highway=hwy)
head(mpg_copy)

df$var_sum <- df$var1 + df$v2
df$var_mean <- df$var_sum / 2
df$var1_10 <- df$var1 * 10
df

mpg$total <- (mpg$cty + mpg$hwy) / 2
head(mpg, 3)
summary(mpg$total)
hist(mpg$total)

mpg$test <- ifelse(mpg$total >= 20, 'pass', 'fail')
head(mpg)

table(mpg$test)
table(mpg$total >= 20)
mpg$test
qplot(mpg$test)

mpg$grade <- ifelse(mpg$total >= 30, 'A', ifelse(mpg$total >= 20, 'B', 'C'))
head(mpg, 3)
table(mpg$grade)
qplot(mpg$grade)

# 문제 1
midwest <- ggplot2::midwest

# 문제 2
midwest <- rename(midwest, total=poptotal, asian=popasian)

# 문제 3 
midwest$rate <- (midwest$asian / midwest$total)
hist(midwest$rate)

# 문제 4
mean(midwest$rate)
midwest$test <- ifelse(midwest$rate > mean(midwest$rate), 'large', 'small')

# 문제 5
table(midwest$test)
qplot(midwest$test)
