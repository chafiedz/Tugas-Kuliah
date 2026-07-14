import pandas as pd
import numpy as np
import statsmodels.api as sm
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import cross_val_score, KFold

# Load dataset Boston Housing
data_url = "http://lib.stat.cmu.edu/datasets/boston"
raw_df = pd.read_csv(data_url, sep=r"\s+", skiprows=22, header=None)
data = np.hstack([raw_df.values[::2, :], raw_df.values[1::2, :2]])
target = raw_df.values[1::2, 2]

column = [
    'CRIM', 'ZN', 'INDUS', 'CHAS', 'NOX', 'RM', 'AGE', 'DIS', 'RAD', 'TAX', 'PTRATIO', 'B', 'LSTAT'
]
df = pd.DataFrame(data, columns=column)
df['MEDV'] = target

# ==== Model 1: MEDV ~ RM + LSTAT ====
x1 = df[['RM', 'LSTAT']]
x1_const = sm.add_constant(x1)
y = df['MEDV']

model1 = sm.OLS(y, x1_const).fit()
print("=== Model 1: MEDV ~ RM + LSTAT ===")
print(model1.summary())
print(f"AIC Model 1: {model1.aic:4f}\n")
# ==== Model 2: MEDV ~ RM + LSTAT + PTRATIO + AGE ====
X2 = df[['RM', 'LSTAT', 'PTRATIO', 'AGE']]
X2_const = sm.add_constant(X2)

model2 = sm.OLS(y, X2_const).fit()
print("=== Model 2: MEDV ~ RM + LSTAT + PTRATIO + AGE ===")
print(model2.summary())
print(f"AIC Model 2: {model2.aic:.4f}\n")

# ==== Cross-Validation (5-fold) ====
lr1 = LinearRegression()
lr2 = LinearRegression()

cv_scores1 = cross_val_score(lr1, x1, y, cv=5, scoring='neg_mean_squared_error')
cv_scores2 = cross_val_score(lr2, X2, y, cv=5, scoring='neg_mean_squared_error')

rmse1 = np.sqrt(-cv_scores1)
rmse2 = np.sqrt(-cv_scores2)

print("=== Cross-Validation (5-fold) ===")
print(f"Model 1 - RMSE tiap fold : {rmse1}")
print(f"Model 1 - Rata-rata RMSE: {rmse1.mean():.4f}")
print(f"Model 2 - RMSE tiap fold : {rmse2}")
print(f"Model 2 - Rata-rata RMSE: {rmse2.mean():.4f}")

# ==== Ringkasan Perbandingan ====
print("\n=== Ringkasan ===")
print(f"AIC Model 1: {model1.aic:.4f} | CV RMSE Model 1: {rmse1.mean():.4f}")
print(f"AIC Model 2: {model2.aic:.4f} | CV RMSE Model 2: {rmse2.mean():.4f}")