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

print ''
print '--------- Optimal Buy/Sell for close ----------'
print 'Buy at close price ' + df.close.min() + ' on ' + str(df.close.idxmin())
print 'Sell at close price ' + df.close.max() + ' on ' + str(df.close.idxmax())
print' Profit: ' + str(float(df.close.max()) - float(df.close.min())) + ' SEK per share'
print ''
print '--------- Optimal Buy/Sell for low/high ----------'
print 'Buy at low price ' + df.low.min() + ' on ' + str(df.low.idxmin())
print 'Sell at high price ' + df.high.max() + ' on ' + str(df.high.idxmax())
print' Profit: ' + str(float(df.high.max()) - float(df.low.min())) + ' SEK per share'

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