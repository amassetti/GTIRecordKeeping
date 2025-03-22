DELIMITER $$

CREATE PROCEDURE UpsertGrade(
    IN p_student_id INT,
    IN p_subject_id INT,
    IN p_assesment_1 DECIMAL(10,0),
    IN p_assesment_2 DECIMAL(10,0),
    IN p_assesment_3 DECIMAL(10,0),
    IN p_final_exam DECIMAL(10,0)
)
BEGIN
    IF EXISTS (SELECT 1 FROM grade WHERE student_id = p_student_id AND subject_id = p_subject_id) THEN
        -- UPDATE
        UPDATE grade
        SET
            assesment_1 = p_assesment_1,
            assesment_2 = p_assesment_2,
            assesment_3 = p_assesment_3,
            final_exam = p_final_exam
        WHERE student_id = p_student_id AND subject_id = p_subject_id;

    ELSE
        -- INSERT
        INSERT INTO grade
            (student_id, subject_id, assesment_1, assesment_2, assesment_3, final_exam)
        VALUES
            (p_student_id, p_subject_id, p_assesment_1, p_assesment_2, p_assesment_3, p_final_exam);

    END IF;
END $$

DELIMITER ;