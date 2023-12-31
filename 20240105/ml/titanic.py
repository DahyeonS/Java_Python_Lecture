# -*- coding: utf-8 -*-
#%%
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import missingno as msno
import warnings
warnings.filterwarnings('ignore')

#%%
data_files = ['../data/titanic/train.csv', '../data/titanic/test.csv']
train = pd.read_csv(data_files[0])
test = pd.read_csv(data_files[1])

#%%
train.info()

#%%
train.head().T

#%%
test.info()

#%%
train.shape, test.shape

#%%
train.isnull().sum()

#%%
test.isnull().sum()

#%%
msno.matrix(df=train.loc[:,:], figsize=(8,8), color=(0.5,0.5,0.5))

#%%
msno.bar(df=train.loc[:,:], figsize=(8,8), color=(0.8,0.5,0.2))

#%%
f, ax = plt.subplots(1, 2, figsize=(18,8))

train.Survived.value_counts().plot.pie(
    explode=[0,0.1], autopct='%1.1f%%', ax=ax[0], shadow=True    
)
ax[0].set_title('Pie plot - Survived')
ax[0].set_ylabel('')

sns.countplot(x='Survived', data=train, ax=ax[1])
ax[1].set_title('Count plot - Survived')

plt.show()

#%%
def bar_chart(feature) :
    cond1 = train['Survived'] == 1
    cond2 = train['Survived'] == 0
    survived = train.loc[cond1, feature].value_counts()
    dead = train.loc[cond2, feature].value_counts()
    df = pd.DataFrame([survived, dead])
    df.index = ['survived', 'dead']
    df.plot(kind='bar', stacked=True, figsize=(10,5))

#%%
train.head(1)
bar_chart('Sex')

#%%
bar_chart('Pclass')

#%%
bar_chart('SibSp')

#%%
bar_chart('Parch')

#%%
f, ax = plt.subplots(1, 2, figsize=(18,8))

sns.violinplot(x='Pclass', y='Age', hue='Survived', data=train, scale='count', split=True, ax=ax[0])
ax[0].set_title('Pclass and Age vs Survived')
ax[0].set_yticks(range(0, 110, 10))

sns.violinplot(x='Sex', y='Age', hue='Survived', data=train, scale='count', split=True, ax=ax[1])
ax[1].set_title('Sex and Age vs Survived')
ax[1].set_yticks(range(0, 110, 10))

plt.show()

#%%
train.head(2).T

#%%
test.head(2).T

#%%
train_test_data = [train, test]

#%%
for data in train_test_data :
    data['Title'] = data['Name'].str.extract('([A-Za-z]+)\.', expand=False)

#%%
train['Title'].value_counts()

#%%
test['Title'].value_counts()

#%%
train['Title'].value_counts().index

#%%
mapping = {
    "Mr":0,"Miss":1,"Mrs":2,
    "Master":3, "Dr":3, "Rev":3, "Col": 3, 'Ms': 3, 'Mlle': 3, "Major": 3, 'Lady': 3, 'Capt': 3,
    'Sir': 3, 'Don': 3,'Dona': 3,'Mme':3, 'Jonkheer': 3, 'Countess': 3 
    }

#%%
for data in train_test_data :
    data['Title'] = data['Title'].map(mapping)

#%%
train['Title'].value_counts()

#%%
bar_chart('Title')

#%%
for data in train_test_data :
    if 'Name' in data.columns :
        data.drop('Name', axis=1, inplace=True)

#%%
train.head(2).T

#%%
test.head(2).T

#%%
ft = 'Sex'
train[ft].value_counts()
mapping = {'male':0, 'female':1}
for data in train_test_data :
    data[ft] = data[ft].map(mapping)

#%%
train.head(2).T

#%%
train['Age'].isnull().sum() # 177

#%%
for data in train_test_data :
    data['Age'].fillna(data.groupby('Title')['Age'].transform('median'), inplace = True)

#%%
train['Age'].isnull().sum(), test['Age'].isnull().sum()

#%%
for data in train_test_data :
    cond1 = data['Age'] <= 16
    cond2 = (data['Age'] > 16) & (data['Age'] <= 26)
    cond3 = (data['Age'] > 26) & (data['Age'] <= 36)
    cond4 = (data['Age'] > 36) & (data['Age'] <= 46)
    cond5 = data['Age'] > 46
    
    data.loc[cond1, 'Age'] = 0
    data.loc[cond2, 'Age'] = 1
    data.loc[cond3, 'Age'] = 2
    data.loc[cond4, 'Age'] = 3
    data.loc[cond5, 'Age'] = 4

#%%
train['Age'].value_counts()

#%%
test['Age'].value_counts()

#%%
bar_chart('Age')

#%%
train['Embarked'].isnull().sum() # 2

#%%
ft = 'Embarked'
cond1 = train['Pclass'] == 1
cond2 = train['Pclass'] == 2
cond3 = train['Pclass'] == 3

pclass1 = train.loc[cond1, ft].value_counts()
pclass2 = train.loc[cond2, ft].value_counts()
pclass3 = train.loc[cond3, ft].value_counts()

df = pd.DataFrame([pclass1, pclass2, pclass3])
df.index = ['1st', '2nd', '3rd']
df

#%%
df.plot(kind='bar', stacked=True, figsize=(10, 5))

#%%
for data in train_test_data :
    data['Embarked'].fillna('S', inplace = True)
    
train['Embarked'].isnull().sum(), test['Embarked'].isnull().sum()

#%%
ft = 'Embarked'
mapping = {'S':0, 'Q':1, 'C':2}
for data in train_test_data :
    data[ft] = data[ft].map(mapping)

#%%
train['Embarked'].value_counts()

#%%
for data in train_test_data :
    data['Fare'].fillna(data.groupby('Pclass')['Fare'].transform('median'), inplace = True)

#%%
test.Fare.isnull().sum()

#%%
train.Fare.min(), train.Fare.max() # (0.0, 512.3292)

#%%
for data in train_test_data :
    cond1 = data['Fare'] <= 17
    cond2 = (data['Fare'] > 17) & (data['Fare'] <= 30)
    cond3 = (data['Fare'] > 30) & (data['Fare'] <= 100)
    cond4 = data['Fare'] > 100
    
    data.loc[cond1, 'Fare'] = 0
    data.loc[cond2, 'Fare'] = 1
    data.loc[cond3, 'Fare'] = 2
    data.loc[cond4, 'Fare'] = 3

#%%
train.Fare.value_counts()

#%%
train.Cabin.str[:1].value_counts()

#%%
train.Cabin.isna().sum() # 687

#%%
for data in train_test_data :
    data.Cabin = data.Cabin.str[:1]

#%%
train.Cabin.value_counts()

#%%
ft = 'Cabin'
cond1 = train['Pclass'] == 1
cond2 = train['Pclass'] == 2
cond3 = train['Pclass'] == 3

pclass1 = train.loc[cond1, ft].value_counts()
pclass2 = train.loc[cond2, ft].value_counts()
pclass3 = train.loc[cond3, ft].value_counts()

df = pd.DataFrame([pclass1, pclass2, pclass3])
df.index = ['1st', '2nd', '3rd']
df

#%%
df.plot(kind='bar', stacked=True, figsize=(10, 5))

#%%
train.Cabin.unique() # array([nan, 'C', 'E', 'G', 'D', 'A', 'B', 'F', 'T'], dtype=object)

#%%
ft = 'Cabin'
mapping = {
    'C':0, 'E':0.1, 'G':0.2, 'D':0.3, 'A':0.4, 'B':0.5, 'F':0.6, 'T':0.7
} # 소수점으로 라벨링
for data in train_test_data :
    data[ft] = data[ft].map(mapping)

#%%
train.Cabin.unique(), test.Cabin.unique()

#%%
for data in train_test_data :
    data.Cabin.fillna(0.2, inplace = True)

#%%
train.Cabin.isnull().sum(), test.Cabin.isnull().sum() # (0, 0)

#%%
train.head(2).T

#%%
train.SibSp.value_counts()

#%%
test.SibSp.value_counts()

#%%
for data in train_test_data :
    data['FamilySize'] = data.SibSp + data.Parch + 1

#%%
sorted(train.FamilySize.unique())

#%%
sorted(test.FamilySize.unique())

#%%
train.FamilySize.value_counts()

#%%
test.FamilySize.value_counts()

#%%
ft = 'FamilySize'
mapping = {
    1:0, 2:0.1, 3:0.2, 4:0.3, 5:0.4, 6:0.5, 7:0.6, 8:0.7, 11:0.8
} # 소수점으로 라벨링
for data in train_test_data :
    data[ft] = data[ft].map(mapping)

#%%
train.FamilySize.value_counts()

#%%
test.FamilySize.value_counts()

#%%
for data in train_test_data :
    data.drop(['PassengerId', 'SibSp', 'Parch', 'Ticket'], axis = 1, inplace = True)

#%%
train.head(5).T

#%%
train.isna().sum()

#%%
test.isna().sum()

#%%
target = train.Survived
train_data = train.drop('Survived', axis=1)

#%%
train_data.shape, target.shape # ((891, 8), (891,))

#%%
train_data.head()

#%%
from sklearn.ensemble import RandomForestClassifier

#%%
model = RandomForestClassifier()
model.fit(train_data, target)

#%%
round(model.score(train_data, target), 2) * 100 # 90.0

#%%
pred = model.predict(test)

#%%
submission = pd.DataFrame(
    {
    'PassengerId':pd.read_csv(data_files[1])['PassengerId'],
    'Survived':pred
    }
)

#%%
submission.to_csv('submission_rf_240105.csv', index=False)

#%%
from sklearn.ensemble import RandomForestClassifier
from sklearn.tree import DecisionTreeClassifier
from sklearn.linear_model import LogisticRegression
from sklearn.ensemble import AdaBoostClassifier
from xgboost import XGBClassifier
from sklearn.metrics import accuracy_score

#%%
# RandomForestClassifier
model1 = RandomForestClassifier()
model1.fit(train_data, target)
predict = model1.predict(train_data)
accuracy = round(model1.score(train_data, target) * 100, 2)
print("Accuracy : ", accuracy, "%")
print("Accuracy : ", accuracy_score(predict,target))

#%%
# DecisionTreeClassifier
model2 = DecisionTreeClassifier()
model2.fit(train_data, target)
predict = model2.predict(train_data)
accuracy = round(model2.score(train_data, target) * 100, 2)
print("Accuracy : ", accuracy, "%")
print("Accuracy : ", accuracy_score(predict,target))

#%%
# LogisticRegression
model3 = LogisticRegression()
model3.fit(train_data, target)
predict = model3.predict(train_data)
accuracy = round(model3.score(train_data, target) * 100, 2)
print("Accuracy : ", accuracy, "%")
print("Accuracy : ", accuracy_score(predict,target))

#%%
# AdaBoostClassifier
model4 = AdaBoostClassifier()
model4.fit(train_data, target)
predict = model4.predict(train_data)
accuracy = round(model4.score(train_data, target) * 100, 2)
print("Accuracy : ", accuracy, "%")
print("Accuracy : ", accuracy_score(predict,target))

#%%
# XGBClassifier
model5 = XGBClassifier()
model5.fit(train_data, target)
predict = model5.predict(train_data)
accuracy = round(model5.score(train_data, target) * 100, 2)
print("Accuracy : ", accuracy, "%")
print("Accuracy : ", accuracy_score(predict,target))
