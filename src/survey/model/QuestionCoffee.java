package survey.model;

import java.util.HashMap;

public class QuestionCoffee {
	private HashMap<String, String[]> tasteRadio = new HashMap<String, String[]>();
	private HashMap<String, String[]> thinkRadio = new HashMap<String, String[]>();
	private HashMap<String, String[]> thinkCheck = new HashMap<String, String[]>();
	private HashMap<String, String[]> cafeRadio = new HashMap<String, String[]>();
	
	{
		String[] tas1 = { "초콜릿, 씁쓸한 맛이 나는 강한 맛의 다크 초콜릿", "달달하고 씹히는 맛의 비스킷", "상큼한 과일향이 나는 레몬 케이크" };
		String[] tas2 = { "달콤하고 부드러운 식감의 빨간 사과", "산미가 있고 씹히는 식감의 녹색 사과" };
		String[] tas3 = { "입안을 가득 채우며 진한 여운을 남기는 강한 맛의 커피", "부드럽고 가벼운 맛의 커피" };
		String[] tas4 = { "매일 아침은 한 잔의 커피로 시작해야죠", "오후에 주로 마셔요. 내 행복", "커피는 시간과 관계없이 언제든 좋아요" };
		String[] tas5 = { "저는 블랙이 좋아요. 아무것도 넣지 않은 순수한 맛의 블랙커피", "우유나 달콤한 향이 들어간 커피가 좋아요" };
		String[] tas6 = { "가볍게 마시기 좋은 작은 사이즈가 딱 좋아요(리스트레소 또는 에스프레소)", "중간사이즈가 좋아요(룽고 또는 그랑룽고)", "큰 사이즈가 좋아요(아메리카노 또는 머그)" };
		tasteRadio.put("케이크가 먹고 싶은 당신. 어떤 디저트가 가장 좋은가요?", tas1);
		tasteRadio.put("사과가 맛있게 익었어요, 어떤 사과가 더 맛있어 보여요?", tas2);
		tasteRadio.put("어떤 맛의 커피가 더 좋은가요?", tas3);
		tasteRadio.put("주로 언제 커피가 마시고 싶어요?", tas4);
		tasteRadio.put("어떤 커피가 좋아요?", tas5);
		tasteRadio.put("사이즈는 어때요?", tas6);
	}

	{
		String[] think1 = { "1~2잔", "3~4잔", "5잔 이상", "거의 마시지 않는다." };
		String[] think2 = { "집", "카페", "회사나 학교 또는 학원", "산책하면서" };
		String[] think3 = { "입이 심심해서", "습관적으로", "졸려서", "맛과 향이 좋아서", "중독이라 안먹으면 머리가 아파서" };
		String[] think4 = { "브랜드마다 맛이 달라요", "커피 맛을 구분할 수 있어요", "커피의 향은 좋아하지만 맛은 좋아하지 않아요", "커피의 맛과 향 모두 좋아요", "써요. 어른의 맛..." };
		thinkRadio.put("하루에 마시는 커피의 양은?", think1);
		thinkRadio.put("주로 커피를 즐기는 장소는?", think2);
		thinkCheck.put("커피를 마시는 이유는?(중복선택 가능)", think3);
		thinkCheck.put("커피 맛에 대한 생각(중복선택 가능)", think4);
	}

	{
		String[] cafe1 = { "프렌차이즈(스타벅스, 이디야, 투썸플레이스 등)", "개인카페" };
		String[] cafe2 = { "맛있어서", "집(혹은 회사)에서 가까워서", "가격이 저렴해서", "매장의 분위기가 좋아서", "좌석이 편하고 분리되어 있어서", "한정판매되는 아이템이 좋고 시즌 메뉴가 좋아서" };
		String[] cafe3 = { "지인과의 만남", "공부나 취업준비", "단체모임", "개인시간" };
		String[] cafe4 = { "좀 비싸요", "커피값이 밥값보다 비싼게 이해가 안가요", "커피전문점의 커피가 비싼건 당연해요", "적당해요" };
		String[] cafe5 = { "2000원 이하", "3000원 이하", "5000원 이하" };
		String[] cafe6 = { "음료만 주문", "간단한 간식과 함께 주문", "든든하게 식사와 함께 주문" };
		String[] cafe7 = { "자주 이용한다", "잘 이용하지 않는다" };
		String[] cafe8 = { "조용하게 공부할 수 있는 북카페", "적당히 소음이 있어 작게 떠들어도 눈치 안보이는 카페", "아기자기하고 사진찍기 좋은 컨셉카페",
							"시끌벅적하지만 내가 크게 떠들어도 눈치 안보이는 사람 많은 카페" };
		cafeRadio.put("주로 이용하는 커피전문점의 형태", cafe1);
		cafeRadio.put("해당 형태의 커피전문점을 선호하는 이유는?", cafe2);
		cafeRadio.put("주로 커피전문점을 찾는 목적은?", cafe3);
		cafeRadio.put("커피전문점의 커피 가격에 대한 생각", cafe4);
		cafeRadio.put("본인이 생각하는 커피 한 잔의 적정 가격은?(아메리카노 기준)", cafe5);
		cafeRadio.put("선호하는 주문의 형태", cafe6);
		cafeRadio.put("테이크아웃 이용 빈도", cafe7);
		cafeRadio.put("선호하는 매장의 분위기", cafe8);
	}

	public HashMap<String, String[]> getTasteRadio() {
		return tasteRadio;
	}

	public HashMap<String, String[]> getThinkRadio() {
		return thinkRadio;
	}

	public HashMap<String, String[]> getThinkCheck() {
		return thinkCheck;
	}

	public HashMap<String, String[]> getCafeRadio() {
		return cafeRadio;
	}

}
