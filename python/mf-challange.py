# coding=utf-8

import pandas as pd
import matplotlib.pyplot as plt
import json
from datetime import timedelta

with open('../buy-sell.json') as json_data:
    d = json.load(json_data)
    json_data.close()

df = pd.DataFrame(d['data'])
df.index = pd.to_datetime(df.quote_date)

print df.close.min()
print df.close.idxmin()
print df.low.min()
print df.low.idxmin()

print df.close.max()
print df.close.idxmax()
print df.high.max()
print df.high.idxmax()

plt.plot_date(df.index,df.close,ls='-',marker=' ')
plt.plot(df.close.idxmin(),float(df.close.min()), marker='o')
plt.plot(df.close.idxmax(),float(df.close.max()), marker='o')

plt.annotate('Buy ' + df.close.idxmin().strftime("%Y-%m-%d"), xy=(df.close.idxmin(),float(df.close.min())), xytext=(df.close.idxmin(),float(df.close.min())-30),
            arrowprops=dict(facecolor='black', shrink=0.05), horizontalalignment='center',
            )
plt.annotate('Sell ' + df.close.idxmax().strftime("%Y-%m-%d"), xy=(df.close.idxmax(),float(df.close.max())), xytext=(df.close.idxmax() - timedelta(days=10),float(df.close.max())+30),
            arrowprops=dict(facecolor='black', shrink=0.05), horizontalalignment='center',
            )
plt.title("Hexagon B")
plt.ylabel('Price SEK')
plt.ylim((150,350))
plt.show()