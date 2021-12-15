export const formatDate = (dateString) => {
  if (!dateString) {
    return;
  }

  const dateObj = new Date(dateString);

  return `${
    dateObj.getUTCMonth() + 1
  }/${dateObj.getUTCDate()}/${dateObj.getUTCFullYear()}`;
};
