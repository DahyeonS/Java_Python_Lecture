# 데이터 가공
library(dplyr)

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

# mpg 데이터
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
