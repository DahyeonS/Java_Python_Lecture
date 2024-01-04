from flask import Flask, request, render_template
from sklearn import svm
import os
import pickle

app = Flask(__name__)

def detect_lang(text) :
    model_file = './model/lang.pick'
    with open(model_file, 'rb') as f :
        clf = pickle.load(f)

    text = text.lower()
    cnt = [0 for n in range(0, 26)]
    code_a = ord('a')
    code_z = ord('z')
    
    for ch in text :
        n = ord(ch)
        
        if code_a <= n <= code_z :
            cnt[n-code_a] += 1
            
    total = sum(cnt)
    freq = list(map(lambda n: n / total, cnt))

    pred = clf.predict([freq])[0]
    return pred

@app.route('/')
def index() :
    return render_template('lang_result.html')

@app.route('/result', methods=['POST'])
def result() : 
    data = request.form['data']
    lang = detect_lang(data)
    return render_template('lang_result.html', result=lang)

if __name__ == '__main__' :
    app.run(debug=True)