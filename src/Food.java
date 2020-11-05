
public class Food {
	
	int categoryNo; // 요리에 해당하는 카테고리 넘버 [0=안주&간식, 1=찌개&국, 2=반찬, 3=밥, 4=간식&기타]
	int recommend; // 추천 수
	int id; // 요리 아이디
	String link; //유튜브 링크
	String name; //요리 이름
	String ingredient; // 재료
	String quantitative;//정량
	String recipe; // 요리 제조법
	String[] recipeArray; // 제조법을 지정한 문자로 나누어 저장하게 될 배열 [(split()함수 사용]
	String[] ingreientArray; //재료들을 지정한 문자로 나누어 저장하게 될 배열 [(split()함수 사용]
	
	public Food(int id,String name, String recipe, String quantitative, String ingreient,String link,int categoryNo) {  // Food 클래스 생성자
		this.name=name;
		this.categoryNo=categoryNo;
		this.ingredient=ingreient;
		this.recipe=recipe;
		this.id=id;
		this.quantitative=quantitative;
		
		recipeArray=recipe.split("#");  // 한줄로 받은 레시피를 #으로 나누어 배열을 생성해준다.
		ingreientArray=ingredient.split("#"); // 한줄로 받은 재료들을 #으로 나누어 배열을 생성해준다.
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
