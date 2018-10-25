package kr.green.spring.pagenation;

public class PageMaker {
//	현재 페이지 정보
	private Criteria criteria;
//	전체 게시글 수
	private int totalCount;
//	한 블록의 시작페이지와 끝페이지 번 호
	private int startPage, endPage;
// 다음 블록으로 가는 이전 버튼과 다음 버튼의 유무
	private boolean prev, next;
// 한 블록에 보여진 페이지의 갯수
	private int displayPageNum;
	
//	현재 페이지 정보와 전체 컨텐츠의 수가 주어지면 멤버 변수의 값을
//	계산하는 메소드로 전체 컨텐츠의 수가 설정되면 호출하면 됨
	public void calcData() {
		endPage =
		(int)Math.ceil(criteria.getPage()/(double)displayPageNum)
			*displayPageNum;
		startPage = endPage - displayPageNum +1;
		
//		위에서 계산한 endPage는 전체 컨텐츠 수를 반영한게 아니라 현재 페이지
//		기준으로 계산된 결과이기 때문에 마지막 블록에서 원하지 않은 결과가
//		발생할수 있음. 따라서 정확한 endPage를 계산하기 위해서는 전체
//		컨텐츠 수가 반영된 값과 비교하여 적용해야 함.
		int tmpEndPage = (int)Math.ceil(totalCount/(double)criteria.getPerPageNum());
		if(tmpEndPage < endPage)
			endPage = tmpEndPage;
//		첫 블록이면 prev 버튼 감추기
		prev = startPage == 1 ? false:true;
//		마지막 블록이면 next 버튼 감추기
		next = endPage*displayPageNum >= totalCount ? false:true;
	}


	public Criteria getCriteria() {
		return criteria;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	@Override
	public String toString() {
		return "PageMaker [criteria=" + criteria + ", totalCount=" + totalCount + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + ", displayPageNum=" + displayPageNum
				+ "]";
	}
}
