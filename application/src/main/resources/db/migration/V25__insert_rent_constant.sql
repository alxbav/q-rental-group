DELETE
from constant
where constant IN ('weekly_rent_fee',
                   'daily_rent_fee');

INSERT INTO constant(constant, value, negative, description)
VALUES ('weekly_rent_fee', 210, true, 'Weekly rent fee');

INSERT INTO constant(constant, value, negative, description)
VALUES ('daily_rent_fee', 40, true, 'Daily rent fee');
