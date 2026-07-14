import pandas as pd
from sklearn.datasets import load_iris
from plotnine import *

# Load dataset
iris = load_iris()
df = pd.DataFrame(iris.data, columns=iris.feature_names)
df['species'] = pd.Categorical.from_codes(iris.target, iris.target_names)

df = df.rename(columns={
    'sepal length (cm)': 'sepal_length',
    'petal length (cm)': 'petal_length'
})

# Scatter plot + regresi per species
plot = (
    ggplot(df, aes(x='sepal_length', y='petal_length', color='species'))
    + geom_point(size=2, alpha=0.7)
    + geom_smooth(method='lm', se=True)
    + labs(
        title='Scatter Plot dengan GoG + Regresi',
        x='sepal length (cm)',
        y='petal length (cm)'
    )
    + theme_light()
)

print(plot)
plot.save('scatter_iris.png', dpi=150, width=6, height=4)