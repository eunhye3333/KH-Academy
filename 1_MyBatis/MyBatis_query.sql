-- 게시물 상세보기
-- 댓글은 1(1), 13(3)번 글에만 달려 있는 상태
select bid, btype, btitle, bcontent, bwriter, nickname, bcount, b_create_date, b_modify_date, b_status
from board 
     join member on(bwriter = user_id);

select b.*, bn.nickname b_nick, r.*, rn.nickname r_nick
from board b
     join member bn on(bwriter = bn.user_id)
     left outer join reply r on(bid = ref_bid)
     left outer join member rn on(rwriter = rn.user_id)
where bid = 13
      and b_status = 'Y'
order by rid desc;

select b.*, bnick.nickname, rep.*
from board b
     join member bnick on(bwriter = bnick.user_id)
     left outer join (select r.*, m.nickname
                      from reply r join member m on(rwriter = user_id)) rep
                on(bid = ref_bid)
where b_status='Y';
                      
-- 1단계 : board
select *
from board
where bid = 13 and b_status='Y';

-- 2단계 : board + member
select bId, btype, btitle, bcontent, bwriter, nickname, bcount, b_create_date, b_modify_date, b_status
from board
	 join member on(bwriter = user_id)
where bid = 13 and b_status = 'Y';

-- 3단계 : board + member + reply
select bId, btype, btitle, bcontent, bwriter, b.nickname b_nick, bcount, b_create_date, b_modify_date, b_status,
       rid, rcontent, ref_bid, rwriter, r.nickname as r_nick, r_create_date, r_modify_date, r_status
from board
	 join member b on(bwriter = b.user_id)
     left join reply on(ref_bid = bid)
     left join member r on(rwriter = r.user_id) 
where bid = 12 and b_status = 'Y'
order by rid desc;
