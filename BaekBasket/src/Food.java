
public class Food {
	
	int categoryNo; // �丮�� �ش��ϴ� ī�װ� �ѹ� [0=����&����, 1=�&��, 2=����, 3=��, 4=����&��Ÿ]
	int recommend; // ��õ ��
	int id; // �丮 ���̵�
	String link; //��Ʃ�� ��ũ
	String name; //�丮 �̸�
	String ingredient; // ���
	String quantitative;//����
	String recipe; // �丮 ������
	String[] recipeArray; // �������� ������ ���ڷ� ������ �����ϰ� �� �迭 [(split()�Լ� ���]
	String[] ingreientArray; //������ ������ ���ڷ� ������ �����ϰ� �� �迭 [(split()�Լ� ���]
	
	public Food(int id,String name, String recipe, String quantitative, String ingreient,String link,int categoryNo) {  // Food Ŭ���� ������
		this.name=name;
		this.categoryNo=categoryNo;
		this.ingredient=ingreient;
		this.recipe=recipe;
		this.id=id;
		this.quantitative=quantitative;
		
		recipeArray=recipe.split("#");  // ���ٷ� ���� �����Ǹ� #���� ������ �迭�� �������ش�.
		ingreientArray=ingredient.split("#"); // ���ٷ� ���� ������ #���� ������ �迭�� �������ش�.
	}
	
	public String getIngredient() {
		return this.ingredient;
	}
	
	public String getRecipe() {
		return this.recipe;
	}
	public String getName() {
		return this.name;
	}
	public String getQuanti() {
		return this.quantitative;
	}

}
