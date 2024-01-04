# -*- coding: utf-8 -*-
#%%
from sklearn import svm

#%%
xor_data = [
    [0, 0, 0],
    [0, 1, 1],
    [1, 0, 1],
    [1, 1, 0]
    ]

#%%
data = []
label = []
for row in xor_data :
    p = row[0]
    q = row[1]
    r = row[2]
    data.append([p, q])
    label.append(r)
    
#%%
clf = svm.SVC()

#%%
clf.fit(data, label)

#%%
pred = clf.predict(data)

#%%
pred # array([0, 1, 1, 0])

#%%
ok = 0; total = 0
for idx, answer in enumerate(label) :
    p = pred[idx]
    if p == answer :
        ok += 1
    total += 1
    
print(f'정답률 {ok} / {total} = {ok/total}') # 정답률 4 / 4 = 1.0

#%%
import pandas as pd
from sklearn import svm, metrics

#%%
xor_df = pd.DataFrame(xor_data)
data = xor_df.loc[:, 0:1]
label = xor_df.loc[:, 2]
label

#%%
clf = svm.SVC()
clf.fit(data, label)

#%%
pre = clf.predict(data)

#%%
score = metrics.accuracy_score(label, pre) * 100
score # 100.0

#%%
from sklearn.datasets import load_iris
iris_data = load_iris()
type(iris_data) # sklearn.utils._bunch.Bunch

#%%
iris_data.keys() # dict_keys(['data', 'target', 'frame', 'target_names', 'DESCR', 'feature_names', 'filename', 'data_module'])

#%%
iris_data['target_names'] # array(['setosa', 'versicolor', 'virginica'], dtype='<U10')

#%%


#%%


#%%


#%%


#%%


#%%


#%%


#%%


#%%


#%%


#%%


#%%


#%%



